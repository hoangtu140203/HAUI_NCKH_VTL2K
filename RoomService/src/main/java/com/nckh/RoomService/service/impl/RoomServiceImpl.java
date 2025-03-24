package com.nckh.RoomService.service.impl;

import com.nckh.RoomService.dto.RoomCreateRes;
import com.nckh.RoomService.dto.RoomCreateRq;
import com.nckh.RoomService.mapper.RoomMapper;
import com.nckh.RoomService.model.Room;
import com.nckh.RoomService.repository.RoomRepository;
import com.nckh.RoomService.service.RoomService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public RoomCreateRes createRoom(RoomCreateRq roomCreateRq) {
        Room room = roomMapper.toRoom(roomCreateRq);
        room = roomRepository.save(room);
        room.setRoomName("Default Room"+room.getRoomId());
        room = roomRepository.save(room);
        return roomMapper.toRoomCreateRes(room);
    }

    @Override
    public List<RoomCreateRes> getRooms(Long userId) {
        List<Room> rooms = roomRepository.findByUserId(userId);
        return rooms.stream().map(roomMapper::toRoomCreateRes).collect(Collectors.toList());
    }
}
