package com.nckh.sentimentalanlysis.dto.Response;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class PercentageAnalysis {
    public Double POSITIVE;
    public Double NEGATIVE;
    public Double NEUTRAL;

    public PercentageAnalysis() {
        this.POSITIVE = 0.0;
        this.NEGATIVE = 0.0;
        this.NEUTRAL = 0.0;
    }

    public PercentageAnalysis(Double POSITIVE, Double NEGATIVE, Double NEUTRAL) {
        this.POSITIVE = POSITIVE;
        this.NEGATIVE = NEGATIVE;
        this.NEUTRAL = NEUTRAL;
    }

    public Double getPOSITIVE() {
        return POSITIVE;
    }

    public void setPOSITIVE(Double POSITIVE) {
        this.POSITIVE = POSITIVE;
    }

    public Double getNEGATIVE() {
        return NEGATIVE;
    }

    public void setNEGATIVE(Double NEGATIVE) {
        this.NEGATIVE = NEGATIVE;
    }

    public Double getNEUTRAL() {
        return NEUTRAL;
    }

    public void setNEUTRAL(Double NEUTRAL) {
        this.NEUTRAL = NEUTRAL;
    }
}
