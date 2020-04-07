package com.gemini.chat.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * todo (用一句话描述该文件做什么)
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/6 15:18
 */
public class RegexUtils {

    /**
     * 手机号正则
     */
    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";


    /**
     * 匹配手机号
     * @param mobile
     * @return
     */
    public static boolean matchMobile(String mobile) {

        if (StringUtils.isBlank(mobile)
                || !StringUtils.isNumeric(mobile) || mobile.length() != 11) {
            return false;
        }
        if (mobile.matches(REGEX_MOBILE)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String mobile = "13812345678";
        System.out.println(matchMobile(mobile));
    }
}
