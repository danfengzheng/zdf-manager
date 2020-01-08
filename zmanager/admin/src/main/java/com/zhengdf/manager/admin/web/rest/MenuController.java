package com.zhengdf.manager.admin.web.rest;

import com.zhengdf.manager.admin.conf.aop.Log;
import com.zhengdf.manager.admin.domain.entity.SysMenu;
import com.zhengdf.manager.admin.domain.service.MenuService;
import com.zhengdf.manager.admin.domain.vo.MenuVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @Log("查询菜单")
    @GetMapping("/find")
    public ResponseEntity find(MenuVo vo){
        return ResponseEntity.status(HttpStatus.OK).body(menuService.findMenu());
    }

    @Log("新增菜单")
    @PostMapping("/add")
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
