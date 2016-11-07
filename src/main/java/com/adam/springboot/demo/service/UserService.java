package com.adam.springboot.demo.service;

import com.adam.springboot.demo.dao.UserMapper;
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
}
