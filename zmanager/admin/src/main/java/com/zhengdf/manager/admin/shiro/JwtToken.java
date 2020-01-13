package com.zhengdf.manager.admin.shiro;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationToken;

@Getter
@Setter
public class JwtToken implements AuthenticationToken  {
    private String token;
    private String host;
    public JwtToken(String token) {
        this(token, null);
    }
    public JwtToken(String token, String host) {
        this.token = token;
        this.host = host;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }
}
