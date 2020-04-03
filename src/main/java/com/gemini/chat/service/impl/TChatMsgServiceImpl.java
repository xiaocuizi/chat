package com.gemini.chat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gemini.chat.entity.TChatMsgEntity;
import com.gemini.chat.mapper.TChatMsgMapper;
import com.gemini.chat.service.ITChatMsgService;
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
public class TChatMsgServiceImpl extends ServiceImpl<TChatMsgMapper, TChatMsgEntity> implements ITChatMsgService {

}
