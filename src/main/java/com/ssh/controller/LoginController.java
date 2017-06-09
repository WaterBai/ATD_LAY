package com.ssh.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ssh.entity.User;
import com.ssh.model.LoginInfo;
import com.ssh.service.UserService;

@Controller
@RequestMapping(value = "login")
public class LoginController {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(LoginController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login")
    public ModelAndView login(HttpServletRequest request,
            HttpServletResponse response,@RequestParam Map<String, String> params) {
        LOGGER.info("login/login");        
        LOGGER.info("params:"+params.toString());        
        ModelAndView view = new ModelAndView();
        String userId = params.get("userId");
        String password = params.get("password");
        LoginInfo loginSession = userService.loginUser(userId, password);
        if(loginSession!=null){
            loginSession.setLastLoginIp(request.getRemoteAddr());
            loginSession.setLastLoginTime(new Date());
            LOGGER.info(loginSession.toString());
            request.getSession().setAttribute(LoginInfo.USER_SESSION_KEY, loginSession);
            view.setViewName("redirect:/main/index.do");
        }else{
            view.setView(new RedirectView("../login.jsp"));
        }
        return view;
    }
    
    @RequestMapping(value = "logout")
    public void logout(HttpServletRequest request,
            HttpServletResponse response,@RequestParam Map<String, String> params) {
        LOGGER.info("login/logout");
        request.getSession().invalidate();
        try {
            response.sendRedirect("../login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "register")
    public ModelAndView register(User user) {
        LOGGER.info("login/register");
        ModelAndView view = new ModelAndView();
        boolean success = userService.addUser(user);
        LOGGER.info("register:"+user.toString());
        if(success){
            view.addObject("userId",user.getUserId());
            view.addObject("password",user.getPassword());
            view.setViewName("redirect:/login/login.do");
        }else{
            view.setView(new RedirectView("../register.jsp"));
        }
        return view;
    }
}
