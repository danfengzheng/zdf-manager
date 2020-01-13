package com.zhengdf.manager.admin.web.rest;


import com.zhengdf.manager.admin.constant.CommonEnums;
import com.zhengdf.manager.admin.domain.response.ResponseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/index")
public class IndexController {

    @RequestMapping("/")
    public ResponseInfo index(){
        log.info("index------------");
        return ResponseInfo.getInstance(CommonEnums.SUCCESS);
    }
}
