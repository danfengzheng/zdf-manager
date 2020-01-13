package com.zhengdf.manager.admin.web.rest;

import com.zhengdf.manager.admin.conf.aop.Log;
import com.zhengdf.manager.admin.constant.CommonEnums;
import com.zhengdf.manager.admin.domain.entity.SysMenu;
import com.zhengdf.manager.admin.domain.response.ResponseInfo;
import com.zhengdf.manager.admin.domain.service.MenuService;
import com.zhengdf.manager.admin.domain.vo.MenuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Owner
 */
@Slf4j
@RestController
@Api(tags = "系统：菜单管理")
@RequestMapping(value = "/api/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @Log("查询菜单")
    @GetMapping("/find")
    @ApiOperation("查询菜单")
    @RequiresPermissions("menu:list")
    public ResponseInfo find(MenuVo vo){
//        return ResponseInfo.builder(HttpStatus.OK).body(menuService.findMenu());
        return ResponseInfo.success();
    }

    @Log("新增菜单")
    @PostMapping("/add")
    @ApiOperation("新增菜单")
    @RequiresPermissions("menu:add")
    public ResponseEntity add(@RequestBody MenuVo vo){
        SysMenu menu = SysMenu.builder().build();
        BeanUtils.copyProperties(vo,menu);
        menuService.save(menu);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public static void main(String[] args) {
        MenuVo vo = new MenuVo();
        System.out.println(vo.getParentId());
    }
}
