package com.nckh.RoomService.mapper;

import com.nckh.RoomService.dto.RoomCreateRes;
import com.nckh.RoomService.dto.RoomCreateRq;
import com.nckh.RoomService.model.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room toRoom(RoomCreateRq roomCreateRq);
    RoomCreateRes toRoomCreateRes(Room room);
}
