package com.zhengdf.manager.admin.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author zhengdf
 * @Date 2020/1/8 17:44
 * @Version 1.0
 * @Memo
 **/
@RestController
@Api(tags = "系统：用户管理")
@RequestMapping("/api/user")
public class UserController {



    @ApiOperation("用户查询")
    @GetMapping(value = "/find")
    public ResponseEntity find(){
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation("用户新增")
    @PostMapping(value = "/add")
    public ResponseEntity add(){
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation("用户修改")
    @PostMapping(value = "/edit")
    public ResponseEntity edit(){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
