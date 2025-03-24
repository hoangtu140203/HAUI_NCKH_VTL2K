package com.dsh2t.apigateway.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class UserDto {
    private long userId;
    private String username;
    private String roles;
    private String issuedAt;
    private String expiresAt;
}
