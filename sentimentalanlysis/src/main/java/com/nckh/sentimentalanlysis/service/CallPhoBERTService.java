package com.nckh.sentimentalanlysis.service;

import com.nckh.sentimentalanlysis.dto.TextIn;
import com.nckh.sentimentalanlysis.dto.TextOut;

import java.util.List;

public interface CallPhoBERTService {
    List<TextOut> sentimentAnalysis(List<TextIn> textIn);
}
