package com.test2.demo.controller;

import com.test2.demo.dao.UserRepository;
import com.test2.demo.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping("/")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
