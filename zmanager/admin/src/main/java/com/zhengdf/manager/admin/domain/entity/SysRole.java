package com.zhengdf.manager.admin.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * @ClassName SysRole
 * @Description TODO
 * @Author zhengdf
 * @Date 2020/1/9 14:30
 * @Version 1.0
 * @Memo
 **/
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sys_role")
public class SysRole {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    private String roleId;
    @Column(nullable = false, unique = true)
    private String role;
    private String description;
    private Boolean available = Boolean.TRUE;

    /*角色 -- 权限关系：多对多关系;*/

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private Set<SysMenu> permissions;

    /*用户 - 角色关系定义;*/

    @ManyToMany
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "userId")})
    /*一个角色对应多个用户*/

    private Set<SysUser> users;

}
