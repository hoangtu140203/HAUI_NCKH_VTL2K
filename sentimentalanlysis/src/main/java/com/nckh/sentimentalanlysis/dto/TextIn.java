package com.nckh.sentimentalanlysis.dto;

public class TextIn {
    private String text;

    public TextIn() {
    }

    public TextIn(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
