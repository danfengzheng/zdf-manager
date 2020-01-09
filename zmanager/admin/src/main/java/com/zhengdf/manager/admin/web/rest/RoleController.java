package com.zhengdf.manager.admin.web.rest;

import com.zhengdf.manager.admin.domain.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RoleController
 * @Description TODO
 * @Author zhengdf
 * @Date 2020/1/9 15:12
 * @Version 1.0
 * @Memo
 **/
@Slf4j
@RestController
@Api(tags = "系统：角色管理")
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService service;

    @ApiOperation("角色查询")
    @GetMapping("/find")
    public ResponseEntity find(){
        return ResponseEntity.status(HttpStatus.OK).body(service.find());
    }


    @PostMapping("/add")
    @ApiOperation("新增角色")
    public ResponseEntity add(){
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/edit")
    @ApiOperation("修改角色")
    public ResponseEntity edit(){
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
