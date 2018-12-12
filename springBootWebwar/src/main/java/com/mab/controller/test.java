package com.mab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 马斌 on 2018/11/12.
 */
@Controller
public class test {
//    @GetMapping(value = "/sendto")
    @RequestMapping(value = "/sendto",method = RequestMethod.GET)
    public String test(Model model){
        model.addAttribute("msg","成功");
        return "success";
    }
}
