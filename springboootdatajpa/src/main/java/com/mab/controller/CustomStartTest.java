package com.mab.controller;

import com.mab.HelloProperties;
import com.mab.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebMvcProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 马斌 on 2018/12/5.
 */
@RestController
public class CustomStartTest {
    @Autowired
    HelloService helloService;
//    @Autowired
//    HelloProperties helloProperties;

    @GetMapping("/getStartHello/{name}")
    public String getStartHello(@PathVariable("name") String name){
//        helloProperties.setPrefix("cesi");
//        helloService.setHelloProperties(helloProperties);
        return helloService.sayHello(name);
    }
}
