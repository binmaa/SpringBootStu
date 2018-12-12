package com.mab.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * Created by 马斌 on 2018/11/5.
 */
@Component
public class ErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        map.put("author", "mabin");
        Map<String, Object> ext = (Map<String, Object>) requestAttributes.getAttribute("ext", 0);
        map.put("ext", ext);
        return map;
//        return super.getErrorAttributes(requestAttributes, includeStackTrace);
    }
}
