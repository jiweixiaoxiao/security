package com.uizhi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.uizhi.dto.User;
import com.uizhi.exception.UserNotExitsException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-08
 * Time: 20:33
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query() {
        List<User> user = new ArrayList<>();
        user.add(new User());
        user.add(new User());
        user.add(new User());
        return user;
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable Integer id) {
    //    throw new UserNotExitsException(id);
        System.out.println("调用getinfo()服务");
        User user = new User();
        user.setUserName("lisi");
        return user;
    }

    @PostMapping
    public User create(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
        }
        System.out.println("userid=[" + user.getId() + "]");
        System.out.println("username = [" + user.getUserName() + "]");
        System.out.println("userpassword = [" + user.getPassword() + "]");
        System.out.println("userBirthday=[" + user.getBirthDay() + "]");
        user.setId(1);
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().forEach(objectError -> {
//                        FieldError fieldError = (FieldError) objectError;
//                        String message = fieldError.getField() + " " + fieldError.getDefaultMessage();
//                        System.out.println(message);
                        System.out.println(objectError.getDefaultMessage());
                    }
            );
        }
        System.out.println("userid=[" + user.getId() + "]");
        System.out.println("username = [" + user.getUserName() + "]");
        System.out.println("userpassword = [" + user.getPassword() + "]");
        System.out.println("userBirthday=[" + user.getBirthDay() + "]");
        user.setId(1);
        return user;

    }


    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id){
        System.out.println(id);
    }
}
