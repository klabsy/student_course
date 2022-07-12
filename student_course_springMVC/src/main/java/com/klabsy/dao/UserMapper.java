package com.klabsy.dao;

import com.klabsy.pojo.User;

import java.util.List;

public interface UserMapper {

    //增加一个User
    int addUser(User user);
    //根据id删除一个User
    int deleteUserById(int Sno);
    //更新User
    int updateUser(User user);
    //根据id查询,返回一个Book
    String queryUserById(String username);
    int queryUserByper(String username);
    //查询全部User,返回list集合
    List<User> queryAllUser();

}
