package com.zhengdf.manager.admin.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.sql.Update;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * @ClassName SysUser
 * @Description TODO
 * @Author zhengdf
 * @Date 2020/1/8 18:04
 * @Version 1.0
 * @Memo
 **/
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sys_user")
public class SysUser {
    @Id
    @NotNull(groups = Update.class)
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    private String userId;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String userPass;
    private Integer userStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createTime;
    private Integer logErr;

    /*立即从数据库中进行加载数据;*/

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "userId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private Set<SysRole> roles;

}
