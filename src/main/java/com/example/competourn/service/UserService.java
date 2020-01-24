package com.example.competourn.service;

import com.example.competourn.controller.response.Response;
import com.example.competourn.dto.UserDto;
import com.example.competourn.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public Response authenticateUser(final UserDto userDto) {
        Response response;
        if (userDao.checkValidUser(userDto.getUserName())) {
            String dbpassword = userDao.getLoginCredentials(userDto.getUserName());

            if (userDto.getPassword().equals(dbpassword)) {
                response=Response.ok();
                response.setPayload("Valid User");
            } else {
                response=Response.wrongCredentials();
                response.setPayload("Incorrect Password");
            }
        } else {
            response=Response.notFound();
            response.setPayload ("User Name does not exist");
        }
        return response;
    }
}
