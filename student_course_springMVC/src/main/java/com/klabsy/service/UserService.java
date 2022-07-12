package com.klabsy.service;

import com.klabsy.pojo.User;

import java.util.List;

public interface UserService {
    //增加一个User
    int addUser(User user);
    //根据id删除一个User
    int deleteUserById(int id);
    //更新Student
    int updateUser(User user);
    //根据id查询,返回一个Student
    String queryUserById(String Username);

    int queryUserByper(String Username);

    //查询全部User,返回list集合
    List<User> queryAllUser();
}
