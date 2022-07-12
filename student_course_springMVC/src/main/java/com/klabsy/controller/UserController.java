package com.klabsy.controller;
import com.klabsy.pojo.User;
import com.klabsy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    //查全部
    @RequestMapping("/get_allUser")
    public List<User> get_allUser(){
        List<User> userlist = userService.queryAllUser();
        return userlist; //由于@RestController注解，将list转成json格式返回
    }

    @PostMapping("/add_User")
    public String addUser(@RequestBody User user) {
        System.out.println(user);
        userService.addUser(user);
    //        return "redirect:/tudent/allUser";
        return "addsuccss";
    }

    //删除
    @DeleteMapping("/del_User/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        System.out.println(id);
        userService.deleteUserById(id);
        return "dellsuccss";
    }

    //id查
//    @PostMapping("/id_UpdateUser/{id}")
//    public User id_User(@PathVariable("id") int id){
//        System.out.println(id);
//        User userlist = userService.queryUserById(id);
//        return userlist;
//    }

//    //改
//    @PutMapping("/updateUser/{id}")
//    public String toUpdateUser(@RequestBody User user, @PathVariable("id") int id) {
//        System.out.println(user);
//        user.setId(id);
//        userService.updateUser(user);
//        return "updatesuccss"; //根据当前查询到的对象，进行更新，返回到对应页面
//    }

    @RequestMapping("/login")
    public String login(@RequestBody User user){
        System.out.println(user.getUsername());  //获取用户名
        System.out.println(user.getPwd());   //获取密码
        String username = user.getUsername();
        String pwd = user.getPwd();

        try {
            String password = userService.queryUserById(username); //查找数据库用户名密码
            if(pwd.equals(password)){
                int per = userService.queryUserByper(username);
                String message = Integer.toString(per);
                return message;
            }
            else {
                return "404";
            }
        }catch (Exception e){
            System.out.print(e);
            return "404";
        }
    }
}

