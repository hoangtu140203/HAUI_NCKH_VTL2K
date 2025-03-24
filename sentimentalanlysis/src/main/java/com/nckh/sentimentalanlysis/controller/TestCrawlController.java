package com.nckh.sentimentalanlysis.controller;

import com.nckh.sentimentalanlysis.dto.*;
import com.nckh.sentimentalanlysis.dto.Response.PercentageAnalysis;
import com.nckh.sentimentalanlysis.dto.Response.ResponseForChart;
import com.nckh.sentimentalanlysis.dto.Response.SenAnalysisRes;
import com.nckh.sentimentalanlysis.model.MainLink;
import com.nckh.sentimentalanlysis.model.Post;
import com.nckh.sentimentalanlysis.service.CallCrawlService;
import com.nckh.sentimentalanlysis.service.CallPhoBERTService;
import com.nckh.sentimentalanlysis.service.SenAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sentiment")
public class TestCrawlController {

    @Autowired
    private CallCrawlService callCrawlService;


    @Autowired
    private SenAnalysisService senAnalysisService;

    @Autowired
    private CallPhoBERTService callPhoBERTService;

    @PostMapping("/postPost")
    public Post_Python postPost(@RequestBody Page_info page_info) {
        return callCrawlService.postPost(page_info);
    }

    @PostMapping("/postPage")
    public Page_info postPage(@RequestBody Page_info page_info) {
        return callCrawlService.postPage(page_info);
    }

    @PostMapping("/postCMT")
    public Comment_Res_Py postCMT(@RequestBody Post_Python postPython) {
        Comment_Res_Py comment_res_py = callCrawlService.postComment(postPython);
        return comment_res_py;
    }


    @PostMapping("/createmainlink")
    public MainLink createMainLink(@RequestBody CreatMainLink creatMainLink) {
        return senAnalysisService.saveMainLink(creatMainLink.getMainlink(), creatMainLink.getRoom_id(), creatMainLink.getUser_id());
    }

    @PostMapping("/crawlData")
    public CrawledData crawlData(@RequestBody Page_info page_info) {
        return senAnalysisService.crawlData(page_info);
    }


    @PostMapping("/callphobert")
    public List<TextOut> callPhobert(@RequestBody List<TextIn> textIn) {
        return callPhoBERTService.sentimentAnalysis(textIn);
    }


    @PostMapping("/sentimentAnalysis")
    public SenAnalysisRes sentimentAnalysis(@RequestBody Page_info page_info) {
        return senAnalysisService.sentimentAnalysis(page_info);
    }

    @GetMapping("/getpercentage")
    public ResponseForChart getPercentage(@RequestParam Integer id) {
        return senAnalysisService.percentageAnalysis(id);
    }

    @GetMapping("/getnumber")
    public ResponseForChart getNumber(@RequestParam Integer id) {
        return senAnalysisService.numberAnalysis(id);
    }
}
