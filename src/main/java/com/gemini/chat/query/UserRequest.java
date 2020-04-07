package com.gemini.chat.query;

import lombok.Data;

import java.io.Serializable;

/**
 * todo (用一句话描述该文件做什么)
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/6 14:02
 */
@Data
public class UserRequest implements Serializable {


    private static final long serialVersionUID = 944014414544249764L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户id
     */
    private Long uid;

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 客户端设备id，用于消息推送
     */
    private String cid;

}
