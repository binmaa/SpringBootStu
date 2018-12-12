package com.mab.CustomException;

import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理器
 *
 * Created by 马斌 on 2018/11/5.
 */
@ControllerAdvice
public class ExceptionHandler {
    /**
     * 没有自适应 返回的均为json数据
     * @param e
     * @return
     */
//    @ResponseBody
//    @org.springframework.web.bind.annotation.ExceptionHandler(NotExitException.class)
//    public Object handlerException(Exception e) {
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","exit");
//        map.put("message",e.getMessage());
//        return map;
//    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NotExitException.class)
    public String handlerException(Exception e, HttpServletRequest httpServletRequest) {
        Map<String,Object> map = new HashMap<>();
        map.put("code","exit");
        map.put("message",e.getMessage());
        /**
         * 传入自己的状态码 404 5xx
         * Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
         */
        httpServletRequest.setAttribute("javax.servlet.error.status_code",500);
        httpServletRequest.setAttribute("ext",map);
        return "forward:/error";
    }
}
