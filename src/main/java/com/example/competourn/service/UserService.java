package com.example.competourn.service;

import com.example.competourn.dto.UserDto;
import com.example.competourn.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public String authenticateUser(final UserDto userDto) {

        if (userDao.checkValidUser(userDto.getUserName())) {
            String dbpassword = userDao.getLoginCredentials(userDto.getUserName());

            if (userDto.getPassword().equals(dbpassword)) {
                return ("Valid User");
            } else {
                return ("Incorrect Password");
            }
        } else {
            return ("User does not exist");
        }

    }
}
