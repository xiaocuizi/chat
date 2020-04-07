package com.gemini.chat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gemini.chat.common.JSONResult;
import com.gemini.chat.entity.TUserEntity;
import com.gemini.chat.query.UserRequest;
import com.gemini.chat.vo.UserVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaocuizi
 * @since 2020-04-03
 */
public interface ITUserService extends IService<TUserEntity> {

    /**
     * 用户登录与注册
     * @param userQuery
     * @return
     */
    JSONResult userAction(UserRequest userQuery) throws Exception;

}
