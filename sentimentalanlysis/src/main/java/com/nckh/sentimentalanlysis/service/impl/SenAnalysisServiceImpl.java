package com.nckh.sentimentalanlysis.service.impl;

import com.nckh.sentimentalanlysis.dto.*;
import com.nckh.sentimentalanlysis.dto.Response.PercentageAnalysis;
import com.nckh.sentimentalanlysis.dto.Response.ResponseForChart;
import com.nckh.sentimentalanlysis.dto.Response.SenAnalysisRes;
import com.nckh.sentimentalanlysis.mapper.SenAnalysisMapper;
import com.nckh.sentimentalanlysis.model.Comment;
import com.nckh.sentimentalanlysis.model.MainLink;
import com.nckh.sentimentalanlysis.model.Post;
import com.nckh.sentimentalanlysis.repository.CommentRepository;
import com.nckh.sentimentalanlysis.repository.MainLinkRepository;
import com.nckh.sentimentalanlysis.repository.PostRepository;
import com.nckh.sentimentalanlysis.service.CallCrawlService;
import com.nckh.sentimentalanlysis.service.CallPhoBERTService;
import com.nckh.sentimentalanlysis.service.SenAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SenAnalysisServiceImpl implements SenAnalysisService {



    @Autowired
    private MainLinkRepository mainLinkRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CallCrawlService callCrawlService;

    @Autowired
    private CallPhoBERTService callPhoBERTService;





    @Override
    public MainLink saveMainLink(String mainlink, int room_id, int user_id) {
        MainLink mainLink = new MainLink();
        mainLink.setMainlink(mainlink);
        mainLink.setRoomId(room_id);
        mainLink.setUserId(user_id);
        return mainLinkRepository.save(mainLink);
    }

    @Override
    public CrawledData crawlData(Page_info page_info) {
        //crawl post_content
        Post_Python post_python = callCrawlService.postPost(page_info);
        //crawl comment
        Comment_Res_Py comment_res_py = callCrawlService.postComment(post_python);

        //save
        CrawledData crawledData = new CrawledData();
        crawledData.setMain_link(page_info.getPage_url());
        crawledData.setPost_url(page_info.getPost_url());
        crawledData.setPost_content(post_python.getPost_content());
        crawledData.setComments(comment_res_py.getComments());
        return crawledData;
    }

    @Override
    public SenAnalysisRes sentimentAnalysis(Page_info page_info) {
        CrawledData crawledData = crawlData(page_info);

        MainLink mainLink = mainLinkRepository.findFirstByMainlink(page_info.getPage_url());


        List<TextIn> textIns = new ArrayList<>();
        List<TextOut> textOuts = new ArrayList<>();

        //sent analysis post content
        Post post = new Post();
        post.setPostUrl(crawledData.getPost_url());
        textIns.add(new TextIn(crawledData.getPost_content()));
        textOuts = callPhoBERTService.sentimentAnalysis(textIns);
        System.out.println(textOuts.get(0).getSentence());
        post.setContent(textOuts.get(0).getSentence());
        post.setSenAnalysis(textOuts.get(0).getSentiment());
        post.setConfidence(textOuts.get(0).getConfidence());
        post.setClass_Label(textOuts.get(0).getClass_label());
        post.setMainLink(mainLink);
        Post savePost = postRepository.save(post);

        //refresh textIns and textOuts
        textIns.clear();
        textOuts.clear();

        //sent analysis comments
        List<Comment> comments = new ArrayList<>();
        for (int i =0;i< crawledData.getComments().size();i++) {
            textIns.add(new TextIn(crawledData.getComments().get(i).getCmt_content()));
        }
        textOuts = callPhoBERTService.sentimentAnalysis(textIns);
        for (int i =0;i< crawledData.getComments().size();i++) {
            Comment comment = new Comment();
            comment.setUser(crawledData.getComments().get(i).getCmt_creator());
            comment.setContent(crawledData.getComments().get(i).getCmt_content());
            comment.setCreatedAt(OffsetDateTime.parse(crawledData.getComments().get(i).getCmt_time()));
            comment.setSenAnalysis(textOuts.get(i).getSentiment());
            comment.setConfidence(textOuts.get(i).getConfidence());
            comment.setClass_label(textOuts.get(i).getClass_label());
            comment.setPost(savePost);
            comments.add(comment);
        }
        commentRepository.saveAll(comments);
        Post post1 = postRepository.findById(savePost.getLinkId()).get();
        List<Comment> comments1 = commentRepository.findByPost_LinkId(savePost.getLinkId());
        post1.setComments(comments1);
        SenAnalysisRes senAnalysisRes = new SenAnalysisRes();
        senAnalysisRes = SenAnalysisMapper.mapToSenAnalysisRes(post1);
        return senAnalysisRes;
    }

    @Override
    public ResponseForChart percentageAnalysis(Integer linkId) {
        ResponseForChart response = new ResponseForChart();
        List<String> labels = new ArrayList<>();
        List<Number> data = new ArrayList<>();
        List<Object[]> percentageAnalysis = commentRepository.getSentimentPercentageByLinkId(linkId);
        for (Object[] entry : percentageAnalysis) {
            labels.add((String) entry[0]);
            data.add((BigDecimal) entry[1]);
        }
        response.setLabels(labels);
        response.setData(data);

        return response;
    }

    @Override
    public ResponseForChart numberAnalysis(Integer linkId) {
        ResponseForChart response = new ResponseForChart();
        List<String> labels = new ArrayList<>();
        List<Number> data = new ArrayList<>();
        List<Object[]> percentageAnalysis = commentRepository.getSentimentNumberByLinkId(linkId);
        for (Object[] entry : percentageAnalysis) {
            labels.add((String) entry[0]);
            data.add((Number) entry[1]);
        }
        response.setLabels(labels);
        response.setData(data);

        return response;
    }
}
