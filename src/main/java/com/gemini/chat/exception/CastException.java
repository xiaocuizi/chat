package com.gemini.chat.exception;

import com.gemini.chat.constant.ChatCode;
import lombok.extern.slf4j.Slf4j;

/**
 * 异常抛出类
 */
@Slf4j
public class CastException {
    public static void cast(ChatCode shopCode) {
        log.error(shopCode.toString());
        throw new CustomException(shopCode);
    }
}
