package com.gemini.chat.controller;


import com.gemini.chat.entity.TUserEntity;
import com.gemini.chat.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TUserController {
    @Autowired
    private ITUserService userService;

    @RequestMapping("getUser")
    @ResponseBody
    public Object getUser() {
        TUserEntity tUserEntity = new TUserEntity();
        tUserEntity.setId(1L);
        return userService.getById(tUserEntity);
    }

}
