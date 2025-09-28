package org.example.userServices.controller;

import ch.qos.logback.core.util.StringUtil;
import org.example.userServices.POJO.User;
import org.example.userServices.POJO.UserResponse;
import org.example.userServices.exception.UsernameAlreadyExistsException;
import org.example.userServices.repo.UserRepo;
import org.example.userServices.service.UserValidationService;
import org.example.userServices.utils.constants.UserResponseConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;


@RestController
@RequestMapping("/api/auth")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserValidationService userValidationService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user){
        logger.info(" Creating USER  "+user.getUserName());

        if(userValidationService.validateUser(user.getUserName())){
            System.out.println("User Name Already Available");

            throw new UsernameAlreadyExistsException("User Name Already Available");

        }

        if(StringUtil.notNullNorEmpty(user.getUserPassword()) ){
            String password = passwordEncoder.encode(user.getUserPassword());
            System.out.println(" User Password got encrypted " + user.getUserName());
            user.setUserPassword(password);
        }else{
            System.out.println("Password Not available ");
            throw new UsernameAlreadyExistsException("Password Not available");
        }


        long uniqueId= Calendar.getInstance().getTimeInMillis();

        Date date=Calendar.getInstance().getTime();

        user.setUserId(String.valueOf(uniqueId));
        user.setUserCreationDate(date);
        user.setUserActive(true);

        try{
            User userInstance =userRepo.save(user);

        }
        catch (Exception e){
            System.out.println("Exception occurred during the user saving operation "+e);
            return (ResponseEntity<?>) ResponseEntity.unprocessableEntity();
        }

        return ResponseEntity.ok(user);
    }

    @PostMapping("/login-user")
    public ResponseEntity<?> loginUser(@RequestBody User user){
        UserResponse userResponse= new UserResponse();

        logger.info(" Login Request Came for the USER "+user.getUserName());


        if(StringUtil.notNullNorEmpty(user.getUserName())){
            Optional<User> userOpt=userRepo.findUserByUserName(user.getUserName());
            if(userOpt.isPresent()){
                User usr=userOpt.get();
                logger.info(" User is available with the Name of "+usr.getUserName());
                logger.info(" User Password is getting verified "+usr.getUserName());
                String rawPassword=user.getUserPassword();
                boolean isPasswordMatched = passwordEncoder.matches(rawPassword,usr.getUserPassword());
                if (isPasswordMatched){

                    logger.info(" User Password is verified "+usr.getUserName());
                    logger.info(" User's Name and Password is verified "+usr.getUserName());

                    userResponse.setUserName(usr.getUserName());
                    userResponse.setUserId(usr.getUserId());
                    userResponse.setMessage(UserResponseConstants.user_success);
                    return ResponseEntity.ok(userResponse);

                }else{
                    logger.error(" User is not available with the Name of "+user.getUserName());
                    throw new UsernameAlreadyExistsException("User Name Not available");
                }
            }else{
                logger.error(" User is not available with the Name of "+user.getUserName());
                throw new UsernameAlreadyExistsException("User Name Not available");
            }
        }else{
            logger.error(" User is not available with the Name of "+user.getUserName());
            throw new UsernameAlreadyExistsException("User Name Not available");
        }

    }

}

