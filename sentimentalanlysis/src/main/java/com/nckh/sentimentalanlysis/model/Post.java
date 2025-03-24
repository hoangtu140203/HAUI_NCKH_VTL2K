package com.nckh.sentimentalanlysis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer linkId;

    @Column(columnDefinition = "TEXT")
    private String postUrl;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String senAnalysis;
    private Double confidence;
    private Integer class_Label;

    @ManyToOne
    @JoinColumn(name = "mainlink_id", nullable = false)
    private MainLink mainLink;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> comments;

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
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

    public MainLink getMainLink() {
        return mainLink;
    }

    public void setMainLink(MainLink mainLink) {
        this.mainLink = mainLink;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Integer getClass_Label() {
        return class_Label;
    }

    public void setClass_Label(Integer class_Label) {
        this.class_Label = class_Label;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }
}