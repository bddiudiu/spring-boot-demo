package com.adam.springboot.demo.config.shiro;

import com.adam.springboot.demo.model.Permission;
import com.adam.springboot.demo.model.User;
import com.adam.springboot.demo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by adam on 7/11/16.
 */
@Component("userRealm")
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    public UserRealm() {
        setName("UserRealm");
        // 采用MD5加密
        setCredentialsMatcher(new HashedCredentialsMatcher("md5"));
    }

    /**
     * 获取认证信息
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = String.valueOf(usernamePasswordToken.getUsername());
        User user = userService.findByUserName(username);
        AuthenticationInfo authenticationInfo = null;
        if (null != user) {
//            authenticationInfo = new SimpleAuthenticationInfo(username,user.getPassword(),getName());
            authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
        }else {
            // 抛出 帐号找不到异常
            throw new UnknownAccountException("找不到用户");
        }
        return authenticationInfo;
    }

    /**
     * 获取授权信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.fromRealm(getName()).iterator().next();
        if (username != null) {
            List<Permission> permissionList = userService.getPermissionsByUserName(username);
            if (permissionList != null && !permissionList.isEmpty()) {
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                for (Permission permission : permissionList) {
                    //将权限资源添加到用户信息中
                    info.addStringPermission(permission.getUrl());
                }
                return info;
            }
        }
        return null;
    }
}
