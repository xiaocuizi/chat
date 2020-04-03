package com.gemini.chat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gemini.chat.entity.TUserEntity;
import com.gemini.chat.mapper.TUserMapper;
import com.gemini.chat.service.ITUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaocuizi
 * @since 2020-04-03
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUserEntity> implements ITUserService {

}
