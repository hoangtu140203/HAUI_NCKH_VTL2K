package com.nckh.sentimentalanlysis.dto.Response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
public class CommentAnalysis {
    private Integer commentId;
    private String user;
    private String content;
    private OffsetDateTime createdAt;
    private String senAnalysis;
    private Double confidence;
    private Integer class_label;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
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

    public Integer getClass_label() {
        return class_label;
    }

    public void setClass_label(Integer class_label) {
        this.class_label = class_label;
    }
}
