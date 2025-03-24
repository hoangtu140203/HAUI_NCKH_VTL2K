package com.nckh.sentimentalanlysis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatMainLink {
    public String mainlink;
    public int room_id;
    public int user_id;

    public String getMainlink() {
        return mainlink;
    }

    public void setMainlink(String mainlink) {
        this.mainlink = mainlink;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
