package com.nckh.UserSercvice.model;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "authen")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Many Authen -> One User (UUID)

    private String passwordHash;
    private LocalDateTime lastLogin;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role; // Many Authen -> One Role
}
