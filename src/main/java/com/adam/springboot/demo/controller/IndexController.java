package com.adam.springboot.demo.controller;

import com.adam.springboot.demo.model.User;
import com.adam.springboot.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by adam on 4/11/16.
 */
@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/countries")
    public ModelAndView getAll(User user) {
        ModelAndView result = new ModelAndView("index");
        System.out.println("1231231231");
        logger.debug("1111-================================");
        List<User> userList = userService.queryAllUser(user);
        result.addObject("pageInfo", new PageInfo<User>(userList));
        result.addObject("queryParam", user);
        result.addObject("page", user.getPage());
        result.addObject("rows", user.getRows());
        return result;
    }
}
