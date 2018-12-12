package com.mab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by 马斌 on 2018/10/26.
 */
@Controller
public class LoginController {
    //    @RequestMapping(value = "/user/Login",method = RequestMethod.POST)
//    @GetMapping
//    @DeleteMapping
//    @PutMapping

    /**
     * loginController
     * @param userName
     * @param passWord
     * @param msgMap
     * @param session
     * @return
     */
    @PostMapping(value = "/user/Login")
    public String Login(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord,
                        Map<String, Object> msgMap, HttpSession session) {
        if (!StringUtils.isEmpty(userName) && "123".equals(passWord)) {
            session.setAttribute("userName",userName);
            return "redirect:/main";
        }
        msgMap.put("msg", "用户名或密码错误");
        return "Login";
    }
}
