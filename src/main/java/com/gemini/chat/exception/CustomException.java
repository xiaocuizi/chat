package com.gemini.chat.exception;


import com.gemini.chat.constant.ChatCode;

/**
 * 自定义异常
 */
public class CustomException extends RuntimeException{

    private ChatCode shopCode;

    public CustomException(ChatCode shopCode) {
        this.shopCode = shopCode;
    }
}
