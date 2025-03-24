package com.nckh.sentimentalanlysis.dto.Response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class SenAnalysisRes {
    private Integer linkId;
    private String postUrl;
    private String content;
    private String senAnalysis;
    private Double confidence;
    private Integer class_Label;
    private List<CommentAnalysis> comments;

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenAnalysis() {
        return senAnalysis;
    }

    public void setSenAnalysis(String senAnalysis) {
        this.senAnalysis = senAnalysis;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public Integer getClass_Label() {
        return class_Label;
    }

    public void setClass_Label(Integer class_Label) {
        this.class_Label = class_Label;
    }

    public List<CommentAnalysis> getComments() {
        return comments;
    }

    public void setComments(List<CommentAnalysis> comments) {
        this.comments = comments;
    }
}
