package com.example.userService.POJO;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserResponse {

    private String message;
    private String userName;
    private String userId;
    private String userStatus;

}
