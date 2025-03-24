package com.nckh.sentimentalanlysis.dto.Response;

import java.math.BigDecimal;
import java.util.List;

public class ResponseForChart {
    private List<String> labels;
    private List<Number> data;

    public ResponseForChart() {
    }

    public ResponseForChart(List<String> labels, List<Number> data) {
        this.labels = labels;
        this.data = data;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<Number> getData() {
        return data;
    }

    public void setData(List<Number> data) {
        this.data = data;
    }
}
