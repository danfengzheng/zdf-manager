package com.zhengdf.manager.admin.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sys_menu")
public class SysMenu {

    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    private String menuId;
    private String menuName;
    private String parentId;
    private String menuUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createTime;
    private Integer available;
    private Long menuSort;
    private Long resourceType;

    private String permission;

    /*角色 -- 权限关系：多对多关系;*/

    @ManyToMany
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "menuId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private Set<SysRole> roles;

}
