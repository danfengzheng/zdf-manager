package com.zhengdf.manager.admin.shiro;

import com.zhengdf.manager.admin.domain.entity.SysUser;
import com.zhengdf.manager.admin.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

/**
 * CredentialsMatcher
 * 接口由类实现，该类可以确定是否提供了AuthenticationToken凭证与系统中存储的相应帐户的凭证相匹配。
 * Shiro 加密匹配 重写匹配方法CredentialsMatcher 使用JWTUtil 匹配方式
 */
@Slf4j
public class JWTCredentialsMatcher implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        String token = (String) ((JwtToken)authenticationToken).getToken();
        SysUser user = (SysUser)authenticationInfo.getPrincipals().getPrimaryPrincipal();
        //得到DefaultJwtParser
        Boolean verify = JwtUtils.verify(token, user.getUserName());
        log.info("JWT密码效验结果={}",verify);
        return verify;
    }
}
