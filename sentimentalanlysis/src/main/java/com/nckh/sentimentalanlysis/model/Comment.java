package com.nckh.sentimentalanlysis.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Table(name = "comments")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    private String user;

    @Column(columnDefinition = "TEXT")
    private String content;

    private OffsetDateTime createdAt;
    private String senAnalysis;
    private Double confidence;
    private Integer class_label;

    @ManyToOne
    @JoinColumn(name = "link_id", nullable = false)
    private Post post;

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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Integer getClass_label() {
        return class_label;
    }

    public void setClass_label(Integer class_label) {
        this.class_label = class_label;
    }
}