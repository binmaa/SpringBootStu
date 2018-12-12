package com.mab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by 马斌 on 2018/10/27.
 */
@Controller
public class SignOutController {
    /**
     * url 参数获取方式
     * @param userName
     * @param session
     * @return
     */
    @RequestMapping (value= "/user/SignOut")
    public String SignOut(@RequestParam String userName, HttpSession session){
        //userName未用到
        session.removeAttribute("userName");
//        session.setMaxInactiveInterval(0);
        return "redirect:/index";

    }
}
