package com.zhengdf.manager.admin.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author zhengdf
 * @Date 2020/1/8 17:44
 * @Version 1.0
 * @Memo
 **/
@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping(value = "/add")
    public String add(){

        return "";
    }
}
