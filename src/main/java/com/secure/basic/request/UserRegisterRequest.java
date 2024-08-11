package com.secure.basic.request;

import com.secure.basic.entity.Role;
import lombok.Data;

@Data
public class UserRegisterRequest {


    private String username;
    private String password;
    private Role role;

}
