package com.adam.springboot.demo.dao;

import com.adam.springboot.demo.config.mybatis.MyMapper;
import com.adam.springboot.demo.model.Permission;
import com.adam.springboot.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adam on 4/11/16.
 */
@Repository("userMapper")
public interface UserMapper extends MyMapper<User> {

    List<Permission> getPermissionsByUserName(@Param("username") String username);

}
