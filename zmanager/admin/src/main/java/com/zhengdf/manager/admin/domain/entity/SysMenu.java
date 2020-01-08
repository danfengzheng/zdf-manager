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

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sys_menu")
public class SysMenu {

    @Id
    @NotNull(groups = Update.class)
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    private String menuId;
    private String menuName;
    @Column(columnDefinition = "varchar(20) default '0' ")
    private String parentId;
    private String menuUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createTime;
    private Integer available;
    private Long menuSort;

}
