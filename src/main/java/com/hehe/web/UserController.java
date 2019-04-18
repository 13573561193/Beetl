package com.hehe.web;


import com.hehe.bean.User;
import com.hehe.config.StaticUtil;
import com.hehe.service.UserService;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.*;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/testBeetl")
    public String testBeetl(){

        UserService userService = new UserService();
        List<User> usersInfo = userService.testAllUsers();
        StaticUtil staticUtil = new StaticUtil();
        staticUtil.makeBeetl("usersInfo",usersInfo,"testBeetl","testBeetl_static");
        return "testBeetl_static";
    }
}
