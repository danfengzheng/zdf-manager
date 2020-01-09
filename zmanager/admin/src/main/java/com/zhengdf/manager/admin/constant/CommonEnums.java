package com.zhengdf.manager.admin.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum CommonEnums {
    SUCCESS(0L, "成功"),

    ERROR_COMMON(100001L, "系统异常"),
    /*login msg */
    ERROR_LOGIN_FAIL(100100L, "登录失败"),
    ERROR_PASSWORD(100101L, "密码错误"),

    ERROR_USER_NOT_EXISTS(100102L, "用户不存在"),
    ERROR_ACCOUNT_BLOCKED(100103L, "账户被冻结");

    @Getter
    private Long code;
    @Getter
    private String message;

}
