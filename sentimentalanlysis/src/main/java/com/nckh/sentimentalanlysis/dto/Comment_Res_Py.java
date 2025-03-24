package com.nckh.sentimentalanlysis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment_Res_Py {
    public List<Comment_Python> comments;

    public List<Comment_Python> getComments() {
        return comments;
    }

    public void setComments(List<Comment_Python> comments) {
        this.comments = comments;
    }
}
