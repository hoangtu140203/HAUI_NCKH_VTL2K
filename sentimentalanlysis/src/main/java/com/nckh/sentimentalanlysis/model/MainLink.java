package com.nckh.sentimentalanlysis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "mainlinks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mainlinkId;

    private Integer roomId;
    private Integer userId;
    private String mainlink;

    @OneToMany(mappedBy = "mainLink", cascade = CascadeType.ALL)
    private List<Post> posts;

    public Integer getMainlinkId() {
        return mainlinkId;
    }

    public void setMainlinkId(Integer mainlinkId) {
        this.mainlinkId = mainlinkId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMainlink() {
        return mainlink;
    }

    public void setMainlink(String mainlink) {
        this.mainlink = mainlink;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}