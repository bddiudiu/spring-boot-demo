package com.adam.springboot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by adam on 9/11/16.
 */

@Controller
@RequestMapping("/manage/user/**")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("home")
    public String home(){
        return "home";
    }
}
