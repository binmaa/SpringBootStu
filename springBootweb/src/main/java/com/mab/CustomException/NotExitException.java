package com.mab.CustomException;

/**
 * Created by 马斌 on 2018/11/5.
 */
public class NotExitException extends RuntimeException{
    public NotExitException() {
        super("不存在异常");
    }
}
