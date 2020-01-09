package com.zhengdf.manager.admin.domain.service;

import com.google.common.collect.Lists;
import com.zhengdf.manager.admin.domain.entity.SysRole;
import com.zhengdf.manager.admin.domain.repository.SysRoleRepositor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName RoleService
 * @Description TODO
 * @Author zhengdf
 * @Date 2020/1/9 15:10
 * @Version 1.0
 * @Memo
 **/
@Slf4j
@Service
public class RoleService {
    @Autowired
    private SysRoleRepositor roleRepositor;

    @Transactional
    public List find(){
        List list = roleRepositor.findAll();
        return list;
    }

    public SysRole add(SysRole role){
        return roleRepositor.save(role);
    }
}
