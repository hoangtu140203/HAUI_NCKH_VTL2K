package com.nckh.RoomService.dto;

public class SentimentAnalysis {
    private String sentence;
    private String sentiment;
    private double confidence;
    private int classLabel;

    public SentimentAnalysis(String sentence, String sentiment, double confidence, int classLabel) {
        this.sentence = sentence;
        this.sentiment = sentiment;
        this.confidence = confidence;
        this.classLabel = classLabel;
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

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public int getClassLabel() {
        return classLabel;
    }

    public void setClassLabel(int classLabel) {
        this.classLabel = classLabel;
    }

    @Override
    public String toString() {
        return "SentimentAnalysis{" +
                "sentence='" + sentence + '\'' +
                ", sentiment='" + sentiment + '\'' +
                ", confidence=" + confidence +
                ", classLabel=" + classLabel +
                '}';
    }
}