package com.gemini.chat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gemini.chat.common.JSONResult;
import com.gemini.chat.entity.TUserEntity;
import com.gemini.chat.mapper.TUserMapper;
import com.gemini.chat.query.UserRequest;
import com.gemini.chat.service.ITUserService;
import com.gemini.chat.utils.IDWorker;
import com.gemini.chat.utils.MD5Utils;
import com.gemini.chat.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xiaocuizi
 * @since 2020-04-03
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUserEntity> implements ITUserService {

    // todo 临时存放用户登录状态
    private static final ConcurrentHashMap<String, TUserEntity> userRegistry = new ConcurrentHashMap<String, TUserEntity>();

    @Override
    public JSONResult userAction(UserRequest userQuery) throws Exception {
        TUserEntity userEntity1 = userRegistry.get(userQuery.getUsername());
        if (userEntity1 != null) {
            // 校验密码
            if (!userEntity1.getPassword().equals(MD5Utils.getMD5Str(userQuery.getPassword()))) {
                return JSONResult.errorMsg("用户名或密码不正确。2");
            }
            UserVO userVO = getUserVO(userEntity1);
            return JSONResult.ok(userVO);
        }
        QueryWrapper<TUserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username", userQuery.getUsername());
        TUserEntity userEntity = getOne(wrapper);
        if (userEntity == null) {
            // 注册
            userEntity = new TUserEntity();
            userEntity.setCid(userQuery.getCid());
            userEntity.setUsername(userQuery.getUsername());
            userEntity.setPassword(MD5Utils.getMD5Str(userQuery.getPassword()));
            userEntity.setUid(new IDWorker(5L, 6L).nextId());
            userEntity.setNickname(MD5Utils.getMD5Str(userQuery.getUsername()));
            boolean result = save(userEntity);
            if (result) {
                UserVO userVO = getUserVO(userEntity);
                return JSONResult.ok(userVO);
            }
        } else {
            // 校验密码
            if (!userEntity.getPassword().equals(MD5Utils.getMD5Str(userQuery.getPassword()))) {
                return JSONResult.errorMsg("用户名或密码不正确。3");
            }
            // 登录
            userRegistry.put(userEntity.getUsername(), userEntity);
            UserVO userVO = getUserVO(userEntity);
            return JSONResult.ok(userVO);
        }
        return JSONResult.errorMsg("系统异常，请重试。。");
    }

    private UserVO getUserVO(TUserEntity userEntity1) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userEntity1, userVO);
        // 解决前端json展示精度缺失问题
        userVO.setUid(String.valueOf(userEntity1.getUid()));
        return userVO;
    }
}
