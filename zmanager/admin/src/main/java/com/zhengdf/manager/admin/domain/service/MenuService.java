package com.zhengdf.manager.admin.domain.service;


import com.zhengdf.manager.admin.domain.entity.SysMenu;
import com.zhengdf.manager.admin.domain.repository.SysMenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class MenuService {
    @Autowired
    private SysMenuRepository menuRepository;

    @Transactional
    public List findMenu(){
        List list = menuRepository.findAll();
        return list;
    }

    public SysMenu save(SysMenu menu){
//        menu.setMenuId(IdGen.getId());
        menu.setAvailable(0);
        return menuRepository.save(menu);
    }
}
