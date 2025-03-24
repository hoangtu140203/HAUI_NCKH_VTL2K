package com.nckh.RoomService.service.impl;

import com.nckh.RoomService.dto.SentimentAnalysis;
import com.nckh.RoomService.dto.TextRequest;
import com.nckh.RoomService.service.RestFromPython;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RestFromPythonImpl implements RestFromPython {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://localhost:8000/predict";



    @Override
    public List<SentimentAnalysis> getData(List<TextRequest> textsSendReq) {
        HttpEntity<List<TextRequest>> entity = new HttpEntity<>(textsSendReq);
        List<SentimentAnalysis> sentimentAnalysis = restTemplate.postForObject(url, entity, ArrayList.class);
        return sentimentAnalysis;
    }
}
