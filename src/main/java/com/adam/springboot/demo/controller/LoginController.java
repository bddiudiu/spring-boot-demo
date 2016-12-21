package com.adam.springboot.demo.controller;

import com.adam.springboot.demo.model.User;
import com.adam.springboot.demo.service.UserService;
import com.adam.springboot.demo.utils.EmptyUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by adam on 7/11/16.
 */

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @RequestMapping("")
    public String toLogin(HttpServletRequest request){
//        ModelAndView modelAndView = new ModelAndView();
//        String userName = request.getSession().getAttribute("userName").toString();
//        if (StringUtils.hasText(userName)){
//            modelAndView.setViewName("redirect:manage/user/home");
//        }else {
//            modelAndView.setViewName("login");
//        }
//        return modelAndView;
        return "login";
    }

    @RequestMapping("login")
    public String findLogin(HttpServletRequest request){
        return "login";
    }

    @RequestMapping("doLogin")
    public ModelAndView index(@RequestParam("username")String username, @RequestParam("password")String password, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        logger.debug("用户: "+ username + "开始进行登录");
        User user = userService.findByUserName(username);
        if (EmptyUtil.isEmpty(user)){
            logger.debug("用户不存在,跳转并提示");
        }else {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            try {
                subject.login(token);
                Session session = subject.getSession();
                session.setAttribute("user",user);
            } catch (UnknownAccountException e) {
                logger.error("用户不存在");
                e.printStackTrace();
                modelAndView.addObject("error","用户不存在");
                modelAndView.setViewName("forward:/");
            } catch (IncorrectCredentialsException e) {
                logger.error("用户名/密码错误");
                e.printStackTrace();
                modelAndView.addObject("error","用户不存在");
                modelAndView.setViewName("forward:/");
            } catch (ExcessiveAttemptsException e) {
                // TODO: handle exception
                modelAndView.addObject("error","用户不存在");
                modelAndView.setViewName("forward:/");
            }
        }
        modelAndView.setViewName("redirect:manage/user/home");
        return modelAndView;
    }

    @RequestMapping("logout")
    public String logout(@RequestParam("username") String username){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
            logger.debug("用户" + username + "退出登录");
        }
        return "index";
    }


}
