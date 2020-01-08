package com.zhengdf.manager.admin.domain.repository;

import com.zhengdf.manager.admin.domain.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName SysUserRepository
 * @Description TODO
 * @Author zhengdf
 * @Date 2020/1/8 18:30
 * @Version 1.0
 * @Memo
 **/
public interface SysUserRepository  extends JpaRepository<SysUser, Long>, JpaSpecificationExecutor<SysUser> {
}
