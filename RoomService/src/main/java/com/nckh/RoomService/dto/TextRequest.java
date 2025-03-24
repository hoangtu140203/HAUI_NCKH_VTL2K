package com.nckh.RoomService.dto;

public class TextRequest {
    private String text;

    // Constructor không tham số (cần cho Jackson)
    public TextRequest() {
    }

    // Constructor có tham số
    public TextRequest(String text) {
        this.text = text;
    }

    // Getter và Setter
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextRequest{text='" + text + "'}";
    }
}
