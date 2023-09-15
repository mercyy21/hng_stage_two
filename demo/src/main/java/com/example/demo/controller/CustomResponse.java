package com.example.demo.controller;

import com.example.demo.model.UserEntity;

import java.util.Optional;

public class CustomResponse {
    private String message;
    private int statusCode;
    private Optional<UserEntity> userEntity;

    //Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Optional<UserEntity> getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = Optional.ofNullable(userEntity);
    }
}
