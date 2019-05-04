package com.hehe.service;

import com.hehe.bean.Func;
import com.hehe.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService {


    @Autowired
    public User findOneUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("李文强");
        user.setPassword("12345");
        user.setTelephone("15890904567");
        user.setRegisterTime(new Date());
        user.setPopedom(0);
        return user;
    }


    @Autowired
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<User>();

        User user = new User();
        user.setId(1);
        user.setUsername("李文强");
        user.setPassword("12345");
        user.setTelephone("15890904567");
        user.setRegisterTime(new Date());
        user.setPopedom(0);
        users.add(user);

        user = new User();
        user.setId(2);
        user.setUsername("张海洋");
        user.setPassword("11111");
        user.setTelephone("13990904567");
        user.setRegisterTime(new Date());
        user.setPopedom(1);
        users.add(user);

        user = new User();
        user.setId(3);
        user.setUsername("吴文燕");
        user.setPassword("22222");
        user.setTelephone("15890978905");
        user.setRegisterTime(new Date());
        user.setPopedom(1);
        users.add(user);

        user = new User();
        user.setId(4);
        user.setUsername("郑智化");
        user.setPassword("33333");
        user.setTelephone("15990956905");
        user.setRegisterTime(new Date());
        user.setPopedom(1);
        users.add(user);

        return users;
    }

    @Autowired
    public List<User> testAllUsers() {
        List<User> users = new ArrayList<User>();

        for(int i = 1 ; i <= 3; i++){
            User user = new User();
            user.setId(1);
            user.setUsername("蜘蛛侠");
            user.setPassword("12345");
            user.setTelephone("15680804567");
            user.setRegisterTime(new Date());
            user.setPopedom(0);
            users.add(user);
        }
        return users;
    }

    @Autowired
    public List<Func> getFunctionLists(){
        List<Func> lists = new ArrayList<>();

        Func func1 = new Func("功能111","功能111描述");
        lists.add(func1);
        Func func2 = new Func("功能222","功能222描述");
        lists.add(func2);
        Func func3 = new Func("功能333","功能333描述");
        lists.add(func3);
        Func func4 = new Func("功能444","功能444描述");
        lists.add(func4);
        Func func5 = new Func("功能555","功能555描述");
        lists.add(func5);
        Func func6 = new Func("功能666","功能666描述");
        lists.add(func6);
        Func func7 = new Func("功能777","功能777描述");
        lists.add(func7);
        Func func8 = new Func("功能888","功能888描述");
        lists.add(func8);

        return lists;
    }
    @Autowired
    public List getNavLists(){
        List lists = new ArrayList();
        lists.add("大栏目1");
        lists.add("大栏目2");
        lists.add("大栏目3");
        lists.add("大栏目4");
        lists.add("大栏目5");
        lists.add("大栏目6");
        lists.add("大栏目7");
        lists.add("大栏目8");
        lists.add("大栏目9");

        return lists;
    }
}
