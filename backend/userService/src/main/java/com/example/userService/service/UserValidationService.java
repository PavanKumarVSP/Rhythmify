package com.example.userService.service;

import ch.qos.logback.core.CoreConstants;
import com.example.userService.POJO.User;
import com.example.userService.repo.UserRepo;
import com.example.userService.service.validation.Validater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserValidationService implements Validater<String> {

    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean validateUser(String s) {

        try{
            System.out.println("Validating User "+s);

            Optional<User> user = userRepo.findUserByUserName(s);

            if(user.isPresent()){
                System.out.println("User details are available ");
                System.out.println("User Is "+user);
                return true;
            }
            return false;
        }
        catch (Exception e){
            System.out.println("Exception occurred during "+e);
            return false;
        }

    }
}
