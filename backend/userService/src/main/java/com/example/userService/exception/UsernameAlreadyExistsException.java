package com.example.userService.exception;


import com.example.userService.POJO.UserResponse;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String ExceptionMessage) {
        super(ExceptionMessage);
    }

//    public UsernameAlreadyExistsException(UserResponse userResponse){
//        super(userResponse);
//    }

}
