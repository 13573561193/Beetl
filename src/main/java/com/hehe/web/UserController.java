package com.hehe.web;


import com.hehe.bean.User;
import com.hehe.config.StaticUtil;
import com.hehe.service.UserService;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@Controller
public class UserController {

    StaticUtil staticUtil = new StaticUtil();

    @GetMapping("/testBeetl")
    public String testBeetl(HttpServletRequest request){

        UserService userService = new UserService();
        List<User> usersInfo = userService.testAllUsers();
        staticUtil.makeBeetl("usersInfo",usersInfo,"testBeetl","testBeetl_static",request);
        return "testBeetl_static";
    }
    @GetMapping("/testChar")
    public String testChar(Model model){
        model.addAttribute("numb",111);
        model.addAttribute("numb1",222);
        model.addAttribute("ch_numb","333");
        return "testChar";
    }
    @GetMapping("/testImg")
    public String testImg(HttpServletRequest request){
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/static/testImg_static.html");
        while(!file.exists()){
            staticUtil.makeBeetl("","","testImg","testImg_static",request);
            System.out.println("文件已创建");
        }
            return "testImg_static";
    }
}
