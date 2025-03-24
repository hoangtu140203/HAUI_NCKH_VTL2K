package com.nckh.RoomService.controller;

import com.nckh.RoomService.dto.RoomCreateRes;
import com.nckh.RoomService.dto.RoomCreateRq;
import com.nckh.RoomService.dto.SentimentAnalysis;
import com.nckh.RoomService.dto.TextRequest;
import com.nckh.RoomService.service.RestFromPython;
import com.nckh.RoomService.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private RestFromPython restFromPython;

    @PostMapping("/createRoom")
    public ResponseEntity<RoomCreateRes> createRoom(@RequestHeader("Authorization") String authToken ,@RequestHeader("X-User-Id") String userid,@RequestBody RoomCreateRq roomCreateRq) {
        if (StringUtils.isEmpty(userid)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            roomCreateRq.setUserId(Long.parseLong(userid));
            return ResponseEntity.ok(roomService.createRoom(roomCreateRq));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getRooms")
    public ResponseEntity<List<RoomCreateRes>> getRooms(@RequestParam Long userId) {
        return ResponseEntity.ok(roomService.getRooms(userId));
    }

    @PostMapping("/getAnalysis")
    public ResponseEntity<List<SentimentAnalysis>> getAnalysis(@RequestBody List<TextRequest> texts) {
        List<SentimentAnalysis> sentimentAnalyses = restFromPython.getData(texts);
        return ResponseEntity.ok(sentimentAnalyses);
    }
}
