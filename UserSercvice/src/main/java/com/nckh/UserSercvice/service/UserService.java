package com.nckh.UserSercvice.service;

import com.nckh.UserSercvice.dto.Request.UserRegisterReq;
import com.nckh.UserSercvice.dto.Response.ResponseObject;

public interface UserService {
    ResponseObject register(UserRegisterReq userRegisterReq);
}
