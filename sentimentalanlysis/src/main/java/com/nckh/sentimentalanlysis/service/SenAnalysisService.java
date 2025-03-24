package com.nckh.sentimentalanlysis.service;

import com.nckh.sentimentalanlysis.dto.CrawledData;
import com.nckh.sentimentalanlysis.dto.Page_info;
import com.nckh.sentimentalanlysis.dto.Response.PercentageAnalysis;
import com.nckh.sentimentalanlysis.dto.Response.ResponseForChart;
import com.nckh.sentimentalanlysis.dto.Response.SenAnalysisRes;
import com.nckh.sentimentalanlysis.dto.RoomDTO;
import com.nckh.sentimentalanlysis.model.MainLink;
import com.nckh.sentimentalanlysis.model.Post;

public interface SenAnalysisService {
    MainLink saveMainLink(String mainlink, int room_id, int user_id);
    CrawledData crawlData(Page_info page_info);
    SenAnalysisRes sentimentAnalysis(Page_info page_info);
    ResponseForChart percentageAnalysis(Integer linkId);
    ResponseForChart numberAnalysis(Integer linkId);
}
