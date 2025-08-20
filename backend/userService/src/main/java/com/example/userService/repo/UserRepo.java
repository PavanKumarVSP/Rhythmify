package com.example.userService.repo;

import com.example.userService.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findUserByUserName(String userName);

}
