package com.nckh.sentimentalanlysis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrawledData {

    private String main_link; //page_url
    private String post_url;
    private String post_content;
    private List<Comment_Python> comments;

    public String getMain_link() {
        return main_link;
    }

    public void setMain_link(String main_link) {
        this.main_link = main_link;
    }

    public String getPost_url() {
        return post_url;
    }

    public void setPost_url(String post_url) {
        this.post_url = post_url;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public List<Comment_Python> getComments() {
        return comments;
    }

    public void setComments(List<Comment_Python> comments) {
        this.comments = comments;
    }
}
