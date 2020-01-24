package com.example.competourn.controller.request;

import javax.validation.constraints.NotEmpty;

public class UserSigninRequest {
    @NotEmpty(message = "Email cannot be Empty")
    private String userName;
    @NotEmpty(message = "Password cannot be Empty")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserSigninRequest{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
