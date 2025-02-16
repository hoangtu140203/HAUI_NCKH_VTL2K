package com.nckh.UserSercvice.dto.Request;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserSendOtpReq {
    private String email;
}
