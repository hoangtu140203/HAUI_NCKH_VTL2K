package com.nckh.RoomService.service;

import com.nckh.RoomService.dto.SentimentAnalysis;
import com.nckh.RoomService.dto.TextRequest;

import java.util.List;

public interface RestFromPython {
    List<SentimentAnalysis> getData(List<TextRequest> textsSendReq);
}
