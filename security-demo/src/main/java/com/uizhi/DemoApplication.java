package com.uizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-08
 * Time: 19:29
 */
@SpringBootApplication
@RestController
public class DemoApplication {
    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello spring security";
    }
}
