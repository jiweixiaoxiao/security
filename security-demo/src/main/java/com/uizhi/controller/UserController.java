package com.uizhi.controller;

import com.uizhi.dto.User;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> query(){
        List<User> user = new ArrayList<>();
        user.add(new User());
        user.add(new User());
        user.add(new User());
        return user;
    }
}
