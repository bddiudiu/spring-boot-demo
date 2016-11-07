package com.adam.springboot.demo.dao;

import com.adam.springboot.demo.config.mybatis.MyMapper;
import com.adam.springboot.demo.model.User;

/**
 * Created by adam on 4/11/16.
 */
//@Mapper
public interface UserMapper extends MyMapper<User> {

//    @Select("SELECT * FROM t_sys_user WHERE NAME = #{name}")
//    User findByName(@Param("name") String name);
//
//    @Select("SELECT * FROM t_sys_user WHERE id = #{id}")
//    User findById(@Param("id") Integer id);
//
//
//    @Insert("INSERT INTO t_sys_user(NAME, AGE) VALUES(#{name}, #{age})")
//    int insert(@Param("name") String name, @Param("age") Integer age);
}
