package com.adam.springboot.demo.config.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by adam on 4/11/16.
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
