package com.mab.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * Created by 马斌 on 2018/10/26.
 */
public class LoginHanderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Object userName = httpServletRequest.getSession().getAttribute("userName");
        if (StringUtils.isEmpty(userName)) {
            httpServletRequest.setAttribute("msg","无访问权限 请登录");
            httpServletRequest.getRequestDispatcher("/index").forward(httpServletRequest, httpServletResponse);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
