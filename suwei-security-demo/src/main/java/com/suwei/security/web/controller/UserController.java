package com.suwei.security.web.controller;

import com.suwei.security.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

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

    @PostMapping("/regist")
    public void regist(User user, HttpServletRequest request){
        //注册用户
        String userId = user.getUsername();
        providerSignInUtils.doPostSignUp(userId,new ServletWebRequest(request));
    }
}
