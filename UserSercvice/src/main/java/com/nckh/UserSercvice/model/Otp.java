package com.nckh.UserSercvice.model;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "otp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Otp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long otpId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Many OTPs -> One User (UUID)

    private String otpCode;
    private String otpType; // 'registration', 'password_reset'
    private LocalDateTime otpExpiresAt;
    private boolean isUsed;
    private LocalDateTime createdAt;
}
