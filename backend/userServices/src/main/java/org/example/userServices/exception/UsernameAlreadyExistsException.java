package org.example.userServices.exception;


import org.example.userServices.POJO.UserResponse;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String ExceptionMessage) {
        super(ExceptionMessage);
    }

//    public UsernameAlreadyExistsException(UserResponse userResponse){
//        super(userResponse);
//    }

}
