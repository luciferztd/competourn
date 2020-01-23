package com.example.competourn.controller.api;

import com.example.competourn.controller.request.UserSigninRequest;
import com.example.competourn.dto.Response;
import com.example.competourn.dto.UserDto;
import com.example.competourn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @CrossOrigin
    @PostMapping("/auth")
    public Response paswd(@RequestBody @Valid UserSigninRequest userSigninRequest) {
        UserDto userDto=new UserDto();
        userDto.setUserName(userSigninRequest.getUserName());
        userDto.setPassword(userSigninRequest.getPassword());
        return service.authenticateUser(userDto);
    }
}
