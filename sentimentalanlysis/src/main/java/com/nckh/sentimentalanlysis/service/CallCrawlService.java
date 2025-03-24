package com.nckh.sentimentalanlysis.service;

import com.nckh.sentimentalanlysis.dto.Comment_Res_Py;
import com.nckh.sentimentalanlysis.dto.Page_info;
import com.nckh.sentimentalanlysis.dto.Post_Python;
import com.nckh.sentimentalanlysis.model.Post;

public interface CallCrawlService {
    Page_info postPage(Page_info page_info);
    Post_Python postPost(Page_info page_info);
    Comment_Res_Py postComment(Post_Python post);
}
