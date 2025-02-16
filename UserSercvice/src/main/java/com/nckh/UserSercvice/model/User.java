package com.nckh.UserSercvice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "users") // 'user' is a reserved keyword in some databases
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false, unique = true)
    private UUID userId;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // One User -> Many Authen
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Authen> authenRecords = new ArrayList<>();

    // One User -> Many OTPs
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Otp> otps = new ArrayList<>();
    private boolean isVerified;


}
