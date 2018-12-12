package com.mab.controller;

import com.mab.entity.User;
import com.mab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 马斌 on 2018/12/4.
 */
@RestController
public class UserTest {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userRepository.findOne(id);
        return user;
    }

    @GetMapping("/insertUser")
    public User insertUser(User user){
        User user2 = userRepository.save(user);
        return user2;
    }
}
