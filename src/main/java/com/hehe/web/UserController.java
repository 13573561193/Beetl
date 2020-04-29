package com.hehe.web;


import com.hehe.bean.User;
import com.hehe.config.StaticUtil;
import com.hehe.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    StaticUtil staticUtil = new StaticUtil();

    /**
     * 测试beetl生成静态化页面速度
     * 数据量在UserService.testAllUsers()方法  修改for循环次数
     * @param request
     * @return
     */
    @GetMapping("/testBeetl")
    public String testBeetl(HttpServletRequest request){

        UserService userService = new UserService();
        List<User> usersInfo = userService.testAllUsers();
        long date1 = new Date().getTime();
        staticUtil.makeBeetl("usersInfo",usersInfo,"testBeetl","testBeetl_static",request);
        long date2 = new Date().getTime();
        System.out.println("数据量：" + usersInfo.size() + "条,静态化过程耗时：" + (date2-date1));
        return "testBeetl_static";
    }


/*    @GetMapping("/testChar")
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
    @GetMapping("/test")
    public String test(Model model){
        List<Func> funcInfo = new UserService().getFunctionLists();
        model.addAttribute("funcInfo",funcInfo);
        //List navInfo = new UserService().getNavLists();
        //model.addAttribute("navInfo",navInfo);
        return "module_index";
    }*/
}
