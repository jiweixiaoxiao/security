package com.uizhi.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-08
 * Time: 20:34
 */

public class User {

    //1 用接口来声明多个视图
    public interface UserSimpleView{};
    public interface UserDetailView extends UserSimpleView{};
    private String userName;
    private String password;

    @JsonView(UserSimpleView.class)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
