package com.zhengdf.manager.admin.utils;

import com.zhengdf.manager.admin.domain.entity.SysUser;
import org.apache.shiro.SecurityUtils;

public class UserUtils {
    /*
     * shiro获取当前用户
     * @return
     */
    public static SysUser currentUser() {
        SysUser currentUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        return currentUser;
    }
}
