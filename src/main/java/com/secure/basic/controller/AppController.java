package com.secure.basic.controller;


import com.secure.basic.request.UserRegisterRequest;
import com.secure.basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {
    @Autowired
    private UserService userService;
    @GetMapping(
            path = "v1/api/all"
    )
    public String all() {
        return  "This is All Controller";
    }

    @PostMapping(
            path = "v1/api/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String UserRegister(@RequestBody UserRegisterRequest request) {
        userService.UserRegister(request);
        return  "Oke";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(
            path = "v1/api/admin"
    )
    public String admin() {
        return  "This is Admin Controller";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(
            path = "v1/api/user"
    )
    public String user() {
        return  "This is User Controller";
    }
}
