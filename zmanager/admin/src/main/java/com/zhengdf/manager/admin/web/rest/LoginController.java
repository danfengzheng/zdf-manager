package com.zhengdf.manager.admin.web.rest;

import com.alibaba.fastjson.JSONObject;
import com.zhengdf.manager.admin.conf.aop.Log;
import com.zhengdf.manager.admin.constant.CommonEnums;
import com.zhengdf.manager.admin.domain.entity.SysUser;
import com.zhengdf.manager.admin.domain.response.ResponseInfo;
import com.zhengdf.manager.admin.domain.service.UserService;
import com.zhengdf.manager.admin.domain.vo.LoginVo;
import com.zhengdf.manager.admin.domain.vo.RegisterVo;
import com.zhengdf.manager.admin.utils.IdGen;
import com.zhengdf.manager.admin.utils.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author zhengdf
 * @Date 2020/1/8 17:48
 * @Version 1.0
 * @Memo
 **/
@Slf4j
@RestController
@Api(tags = "登陆注册")
@RequestMapping(value = "/api/index")
public class IndexController {
    @Autowired
    UserService service;

    @Log("用户登录")
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public ResponseInfo login(@RequestBody LoginVo vo) {
        UsernamePasswordToken token = new UsernamePasswordToken(vo.getUsername(),vo.getPassword());
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //主体提交登录请求到SecurityManager
            currentUser.login(token);
        }catch (IncorrectCredentialsException ice){
            return ResponseInfo.getInstance(CommonEnums.ERROR_PASSWORD);
//            model.addAttribute("msg","密码不正确");
        }catch(UnknownAccountException uae){
//            model.addAttribute("msg","账号不存在");
            return ResponseInfo.getInstance(CommonEnums.ERROR_USER_NOT_EXISTS);
        }catch(AuthenticationException ae){
//            model.addAttribute("msg","状态不正常");
            return ResponseInfo.getInstance(CommonEnums.ERROR_ACCOUNT_BLOCKED);
        }
        if(currentUser.isAuthenticated()){
            System.out.println("认证成功");
            JSONObject object = new JSONObject();
            object.put("user", "");
            object.put("token", "token asd123");
            return new ResponseInfo().success(object);
        }else{
            token.clear();
            return ResponseInfo.getInstance(CommonEnums.ERROR_LOGIN_FAIL);
        }
    }

    @Log("用户注册")
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterVo vo) {
        SysUser user = SysUser.builder().build();
        BeanUtils.copyProperties(vo, user);
        log.info("user:{}", user);
        service.add(user);
        log.info("uuid: {}", IdGen.getId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
