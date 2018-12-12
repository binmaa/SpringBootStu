package com.mab.controller;


import com.mab.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 马斌 on 2018/10/16.
 */
@Controller
public class ThmyeleafTest {
    //    @ResponseBody
    @RequestMapping("/succeed")
    public Object testThmyeleaf(Map<String, Object> map) {
        final Map<String, Object> resultMap = map;
        resultMap.put("hello", "thymeleaf");
        resultMap.put("baidu", "http://www.baidu.com");

        List<String> list = new ArrayList<String>();
        list.add("马斌");
        list.add("魏艳荟");
        resultMap.put("list", list);
        Person person = new Person();
        Person value = person;
        value.setName("mabin");
        value.setAge(23);
//        StringBuffer stringBuffer = new StringBuffer();
        resultMap.put("person", value);
        return "succeed";
    }
//    @RequestMapping({"/","/index","/login"})
//    public Object Login(){
//        return "Login";
//    }
}
