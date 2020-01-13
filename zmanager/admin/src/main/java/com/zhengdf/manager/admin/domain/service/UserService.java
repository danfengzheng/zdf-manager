package com.zhengdf.manager.admin.domain.service;

import com.alibaba.fastjson.JSONObject;
import com.zhengdf.manager.admin.domain.entity.SysUser;
import com.zhengdf.manager.admin.domain.mapper.SysUserMapper;
import com.zhengdf.manager.admin.domain.repository.SysUserRepository;
import com.zhengdf.manager.admin.domain.vo.LoginVo;
import com.zhengdf.manager.admin.utils.DateTimeUtil;
import com.zhengdf.manager.admin.utils.IdGen;
import com.zhengdf.manager.admin.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author zhengdf
 * @Date 2020/1/8 18:43
 * @Version 1.0
 * @Memo
 **/
@Slf4j
@Service
@Component
public class UserService {
    @Autowired
    SysUserRepository userRepository;

    @Autowired
    private SysUserMapper userMapper;

    public SysUser add(SysUser user){
        user.setUserId(IdGen.getId());
        user.setUserStatus(0);
        user.setLogErr(0);
        return userRepository.save(user);
    }

    public SysUser findByUserName(String username){
        SysUser user = userRepository.findByUserName(username);
        return user;
    }

    //12小时后过期
    private final static int EXPIRE = 3600 * 12;
    public String createToken(LoginVo vo){
        JSONObject jsonObject = new JSONObject();
        SysUser user = this.findByUserName(vo.getUsername());
        //生成一个token
//        String token = TokenGenerator.generateValue();
        String token = JwtUtils.sign(vo.getUsername(),EXPIRE);
        jsonObject.put("token",token);
        jsonObject.put("expire",EXPIRE);
        return token;
    }
}
