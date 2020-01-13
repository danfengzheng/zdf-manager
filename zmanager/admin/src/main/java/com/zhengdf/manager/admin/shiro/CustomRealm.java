package com.zhengdf.manager.admin.shiro;

import com.google.common.collect.Sets;
import com.zhengdf.manager.admin.domain.entity.SysUser;
import com.zhengdf.manager.admin.domain.service.UserService;
import com.zhengdf.manager.admin.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Slf4j
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    UserService service;
    public CustomRealm(){
        this.setCredentialsMatcher(new JWTCredentialsMatcher());
    }

    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("ShiroRealm的doGetAuthorizationInfo授权方法执行");
        Object principal = principals.getPrimaryPrincipal();
        log.info("ShiroRealm  AuthorizationInfo: {}", principal.toString());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> permissions = Sets.newHashSet();
        permissions.add("menu:list");
        info.setStringPermissions(permissions);
        return info;
    }

    /*认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /**
         * AuthenticationToken
         * JwtToken重写了AuthenticationToken接口 并创建了一个接口token的变量
         *  因为在filter我们将token存入了JwtToken的token变量中
         *  所以这里直接getToken()就可以获取前端传递的token值
         */
        String JWTtoken = ((JwtToken) token).getToken();
        SysUser user = service.findByUserName(JwtUtils.getUsername(JWTtoken));
        return new SimpleAuthenticationInfo(user , user.getUserPass(), "myShiroRealm");
    }
}
