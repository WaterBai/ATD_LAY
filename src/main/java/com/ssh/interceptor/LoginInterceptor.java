package com.ssh.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ssh.model.LoginInfo;
import com.ssh.util.WebConfig;

public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(LoginInterceptor.class);
    @Autowired
    private WebConfig webConfig; // 引用统一的参数配置类

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        LOGGER.debug("preHandle");
        LoginInfo loginSession = (LoginInfo) request.getSession()
                .getAttribute(LoginInfo.USER_SESSION_KEY);
        boolean loginCheck = webConfig.isLoginCheck();
        if (loginCheck) {
            if (loginSession == null) {
                LOGGER.info("尚未登录，返回到登录页面");
                response.sendRedirect("../nologin.jsp");
                return false;
            } else {
                return true;
            }
        }
        if (loginSession == null) {
            loginSession = new LoginInfo();
            loginSession.setUserId("guest");
            loginSession.setUsername("GUEST");
            loginSession.setLastLoginIp(request.getRemoteAddr());
            loginSession.setLastLoginTime(new Date());
            request.getSession().setAttribute(LoginInfo.USER_SESSION_KEY, loginSession);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        LOGGER.debug("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        LOGGER.debug("afterCompletion");
    }

}