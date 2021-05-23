package com.example.aop.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//定义控制器
@Controller
//动议类请求路径
@RequestMapping("/user")
public class UserController {
    //注入用户服务
//    @Autowired
//    private UserService userService;

    @Autowired
    private UserServiceImpl userServiceImpl;

//    private UserValidator userValidator;
    //定义请求
    @RequestMapping("/print")
    //转换成json
    @ResponseBody
    public User printUser(int id,String name,int ege){
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setEge(ege);
//        userService.printUser(user);//若user=null 执行afterthrowing方法
//        UserValidator userValidator = (UserValidator) userService;//强制转换
//        if(userValidator.validate(user)){
//            userService.printUser(user);
//        }
        userServiceImpl.printUser(user);
        return user;//加入断点
    }

}
