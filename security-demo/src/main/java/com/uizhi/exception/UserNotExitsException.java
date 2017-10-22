package com.uizhi.exception;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-22
 * Time: 15:28
 */
public class UserNotExitsException extends RuntimeException{
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserNotExitsException(Integer id) {
        super("用户不存在");
        this.id = id;
    }
}
