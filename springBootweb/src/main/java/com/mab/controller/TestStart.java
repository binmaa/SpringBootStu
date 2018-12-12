package com.mab.controller;

import com.mab.CustomException.NotExitException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 马斌 on 2018/10/15.
 */
@Controller
public class TestStart {
    @ResponseBody
    @RequestMapping("/testStart")
    public String testStart() {
        return "Start Succeed";
    }

    @ResponseBody
    @GetMapping(value= "notExitException")
    public String testCustomException(@RequestParam(value = "id") String id) {
        if ("aaa".equals(id))
            throw new NotExitException();
        return "成功！";
    }
}
