package com.zhengdf.manager.admin.web.rest;

import com.alibaba.fastjson.JSONObject;
import com.zhengdf.manager.admin.domain.response.ResponseInfo;
import com.zhengdf.manager.admin.domain.vo.LoginVo;
import com.zhengdf.manager.admin.domain.vo.RegisterVo;
import com.zhengdf.manager.admin.domain.entity.SysUser;
import com.zhengdf.manager.admin.domain.service.UserService;
import com.zhengdf.manager.admin.utils.IdGen;
import com.zhengdf.manager.admin.conf.aop.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author zhengdf
 * @Date 2020/1/8 17:48
 * @Version 1.0
 * @Memo
 **/
@Slf4j
@RestController
@Api(tags = "登陆注册")
@RequestMapping(value = "/api/index")
public class IndexController {
    @Autowired
    UserService service;

    @Log("用户登录")
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public ResponseInfo login(@RequestBody LoginVo vo){
        log.info("username : {} , password : {}",vo.getUsername(),vo.getPassword());
        JSONObject object = new JSONObject();
        object.put("roles","Admin");
        return ResponseInfo.builder().code(20000L).date(object).build();
    }

    @Log("用户注册")
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterVo vo){
        SysUser user = SysUser.builder().build();
        BeanUtils.copyProperties(vo,user);
        log.info("user:{}",user);
        service.add(user);
        log.info("uuid: {}", IdGen.getId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
