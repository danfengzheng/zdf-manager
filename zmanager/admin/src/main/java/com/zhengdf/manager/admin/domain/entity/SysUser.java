package com.zhengdf.manager.admin.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.signature.qual.Identifier;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.sql.Update;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

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
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    private String userId;
    private String userName;
    private String userPass;
    private Integer userStatus;
    private Long createTime;
    private Integer logErr;
}
