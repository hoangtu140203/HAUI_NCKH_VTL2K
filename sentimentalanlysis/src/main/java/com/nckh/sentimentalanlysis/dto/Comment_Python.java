package com.nckh.sentimentalanlysis.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment_Python {

    public String cmt_content;
    public String cmt_time;
    public String cmt_creator;






    public String getCmt_content() {
        return cmt_content;
    }

    public void setCmt_content(String cmt_content) {
        this.cmt_content = cmt_content;
    }

    public String getCmt_time() {
        return cmt_time;
    }

    public void setCmt_time(String cmt_time) {
        this.cmt_time = cmt_time;
    }

    public String getCmt_creator() {
        return cmt_creator;
    }

    public void setCmt_creator(String cmt_creator) {
        this.cmt_creator = cmt_creator;
    }

}
