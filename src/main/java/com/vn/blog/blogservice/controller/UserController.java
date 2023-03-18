package com.vn.blog.blogservice.controller;

import com.vn.blog.blogservice.dto.User;
import com.vn.blog.blogservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/findUserById/{id}")
    public User findById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }
}
