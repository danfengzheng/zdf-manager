package com.zhengdf.manager.admin.domain.service;

import com.zhengdf.manager.admin.domain.entity.SysUser;
import com.zhengdf.manager.admin.domain.repository.SysUserRepository;
import com.zhengdf.manager.admin.utils.DateTimeUtil;
import com.zhengdf.manager.admin.utils.IdGen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserService {
    @Autowired
    SysUserRepository userRepository;

    public SysUser add(SysUser user){
        user.setUserId(IdGen.getId());
        user.setUserStatus(0);
        user.setLogErr(0);
        return userRepository.save(user);
    }
}
