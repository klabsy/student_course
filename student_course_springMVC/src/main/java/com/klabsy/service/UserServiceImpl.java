package com.klabsy.service;

import com.klabsy.dao.UserMapper;
import com.klabsy.pojo.User;

import java.util.List;

//@Service
public class UserServiceImpl implements UserService {
//    @Autowired
    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }


    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public String queryUserById(String username) {
        return userMapper.queryUserById(username);
    }

    @Override
    public int queryUserByper(String username) {
        return userMapper.queryUserByper(username);
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }
}
