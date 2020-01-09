package com.zhengdf.manager.admin.domain.repository;

import com.zhengdf.manager.admin.domain.entity.SysMenu;
import com.zhengdf.manager.admin.domain.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName SysRoleRepositor
 * @Description TODO
 * @Author zhengdf
 * @Date 2020/1/9 15:09
 * @Version 1.0
 * @Memo
 **/
public interface SysRoleRepositor extends JpaRepository<SysRole, Long>, JpaSpecificationExecutor<SysRole> {
}
