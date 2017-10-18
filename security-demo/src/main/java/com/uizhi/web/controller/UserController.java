package com.uizhi.web.controller;

import com.uizhi.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-08
 * Time: 20:33
 */
@RestController
public class UserController {
    @GetMapping("/user")
    public List<User> query(@RequestParam() String username){
        System.out.println(username);
        List<User> user = new ArrayList<>();
        user.add(new User());
        user.add(new User());
        user.add(new User());
        return user;
    }
}
