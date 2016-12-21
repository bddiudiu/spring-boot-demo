package com.adam.springboot.demo.service;

import com.adam.springboot.demo.dao.UserMapper;
import com.adam.springboot.demo.model.Permission;
import com.adam.springboot.demo.model.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adam on 4/11/16.
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryAllUser(User user){
        if (user.getPage() != null && user.getRows() != null) {
            PageHelper.startPage(user.getPage(), user.getRows(), "id");
        }
        return userMapper.selectAll();
    }

    public User findByUserName(String userName){
        User user = new User();
        user.setUsername(userName);
        return userMapper.selectOne(user);
    }

    public List<Permission> getPermissionsByUserName(String username){
        return userMapper.getPermissionsByUserName(username);
    }
}
