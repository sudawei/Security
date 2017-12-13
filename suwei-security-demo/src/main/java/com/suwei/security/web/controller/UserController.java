package com.suwei.security.web.controller;

import com.suwei.security.dto.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : suwei
 * @description :
 * @date : 2017\11\15 0015 9:31
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails user){
        return user;
    }

    @GetMapping
    public List<User> query(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("a","1"));
        userList.add(new User("b","2"));
        userList.add(new User("c","3"));
        return userList;
    }

    @GetMapping("/{id:\\d+}")
    public User getInfo(@PathVariable("id") String id){
        User a = new User("a", "1");
        return a;
    }
}
