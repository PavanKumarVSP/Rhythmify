package org.example.userServices.repo;

import org.example.userServices.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findUserByUserName(String userName);

}
