package com.nckh.RoomService.service;

import com.nckh.RoomService.dto.RoomCreateRes;
import com.nckh.RoomService.dto.RoomCreateRq;

import java.util.List;

public interface RoomService {
    RoomCreateRes createRoom(RoomCreateRq roomCreateRq);
    List<RoomCreateRes> getRooms(Long userId);
}
