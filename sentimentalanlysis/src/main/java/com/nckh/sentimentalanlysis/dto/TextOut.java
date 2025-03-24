package com.nckh.sentimentalanlysis.dto;

public class TextOut {
    public String sentence;
    public String sentiment;
    public Double confidence;
    public Integer class_label;


    public TextOut() {
    }

    public TextOut(String sentence, String sentiment, Double confidence, Integer class_label) {
        this.sentence = sentence;
        this.sentiment = sentiment;
        this.confidence = confidence;
        this.class_label = class_label;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
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
