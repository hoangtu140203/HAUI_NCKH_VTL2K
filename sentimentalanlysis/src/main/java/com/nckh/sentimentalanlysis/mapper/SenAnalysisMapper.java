package com.nckh.sentimentalanlysis.mapper;

import com.nckh.sentimentalanlysis.dto.Response.CommentAnalysis;
import com.nckh.sentimentalanlysis.dto.Response.SenAnalysisRes;
import com.nckh.sentimentalanlysis.model.Comment;
import com.nckh.sentimentalanlysis.model.Post;

import java.util.stream.Collectors;

public class SenAnalysisMapper {
    public static SenAnalysisRes mapToSenAnalysisRes(Post post) {
        SenAnalysisRes senAnalysisRes = new SenAnalysisRes();
        senAnalysisRes.setLinkId(post.getLinkId());
        senAnalysisRes.setPostUrl(post.getPostUrl());
        senAnalysisRes.setContent(post.getContent());
        senAnalysisRes.setSenAnalysis(post.getSenAnalysis());
        senAnalysisRes.setConfidence(post.getConfidence());
        senAnalysisRes.setClass_Label(post.getClass_Label());
        senAnalysisRes.setComments(post.getComments().stream().map(SenAnalysisMapper::toCommentAnalysis).collect(Collectors.toList()));
        return senAnalysisRes;
    }

    public static CommentAnalysis toCommentAnalysis(Comment comment) {
        CommentAnalysis commentAnalysis = new CommentAnalysis();
        commentAnalysis.setCommentId(comment.getCommentId());
        commentAnalysis.setUser(comment.getUser());
        commentAnalysis.setContent(comment.getContent());
        commentAnalysis.setCreatedAt(comment.getCreatedAt());
        commentAnalysis.setSenAnalysis(comment.getSenAnalysis());
        commentAnalysis.setConfidence(comment.getConfidence());
        commentAnalysis.setClass_label(comment.getClass_label());
        return commentAnalysis;
    }
}
