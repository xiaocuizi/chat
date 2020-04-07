package com.gemini.chat.controller;


import com.gemini.chat.common.JSONResult;
import com.gemini.chat.entity.TUserEntity;
import com.gemini.chat.query.UserRequest;
import com.gemini.chat.service.ITUserService;
import com.gemini.chat.utils.RegexUtils;
import com.gemini.chat.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xiaocuizi
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/u")
@Slf4j
public class TUserController {
    @Autowired
    private ITUserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Object getUser(@RequestBody UserRequest userRequest) {
        log.info("getUser="+userRequest.toString());
        if (StringUtils.isBlank(userRequest.getUsername())
                || StringUtils.isBlank(userRequest.getPassword())) {
            return JSONResult.errorMsg("用户名或密码不能为空。");
        }
        if (!RegexUtils.matchMobile(userRequest.getUsername())) {
            return JSONResult.errorMsg("用户名或密码不正确");
        }

        try {
            JSONResult result = userService.userAction(userRequest);
            log.info("result="+ result.toString());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONResult.errorMsg("系统错误，请重试");
    }


}
