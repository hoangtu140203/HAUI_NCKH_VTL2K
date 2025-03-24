package com.nckh.sentimentalanlysis.service.impl;

import com.nckh.sentimentalanlysis.dto.Comment_Res_Py;
import com.nckh.sentimentalanlysis.dto.Page_info;
import com.nckh.sentimentalanlysis.dto.Post_Python;
import com.nckh.sentimentalanlysis.model.Post;
import com.nckh.sentimentalanlysis.service.CallCrawlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CallCrawlServiceImpl implements CallCrawlService {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8001";

    @Override
    public Page_info postPage(Page_info page_info) {
        String url = URL + "/crawl/postPage";
        HttpEntity<Page_info> request = new HttpEntity<>(page_info);
        return restTemplate.postForObject(url, request, Page_info.class);
    }

    @Override
    public Post_Python postPost(Page_info page_info) {
        String url = URL + "/crawl/postPost";
        HttpEntity<Page_info> request = new HttpEntity<>(page_info);
        return restTemplate.postForObject(url, request, Post_Python.class);
    }

    @Override
    public Comment_Res_Py postComment(Post_Python post) {
        String url = URL + "/crawl/postCMT";
        HttpEntity<Post_Python> request = new HttpEntity<>(post);
        Comment_Res_Py comment_res_py = restTemplate.postForObject(url, request, Comment_Res_Py.class);
        return comment_res_py;
    }
}
