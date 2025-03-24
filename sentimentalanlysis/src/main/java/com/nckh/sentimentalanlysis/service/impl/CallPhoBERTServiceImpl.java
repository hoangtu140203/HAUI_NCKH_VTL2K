package com.nckh.sentimentalanlysis.service.impl;

import com.nckh.sentimentalanlysis.dto.TextIn;
import com.nckh.sentimentalanlysis.dto.TextOut;
import com.nckh.sentimentalanlysis.service.CallPhoBERTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CallPhoBERTServiceImpl implements CallPhoBERTService {

    @Autowired
    private RestTemplate restTemplate;


    private final String URL = "http://localhost:8000/";


    @Override
    public List<TextOut> sentimentAnalysis(List<TextIn> textIn) {
        String url = URL + "predict";

        ResponseEntity<List<TextOut>> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(textIn),
                new ParameterizedTypeReference<List<TextOut>>() {}
        );

        return response.getBody();
    }
}
