package com.myitconfig.shiro.realm;

import com.myitconfig.shiro.pojo.PermissionBean;
import com.myitconfig.shiro.pojo.RoleBean;
import com.myitconfig.shiro.pojo.UserBean;
import com.myitconfig.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 自定义连接器
 * @Author myitconfig
 */
public class UserRealm extends AuthorizingRealm {

    private Logger log = LoggerFactory.getLogger(UserRealm.class);
    @Autowired
    private UserService userService;

    /**
     * @param principalCollection 登录用户
     * @return AuthorizationInfo用户身份信息(角色, 权限)
     * @Description 授权操作
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("执行授权");

        Subject subject = SecurityUtils.getSubject();
        UserBean user = (UserBean) subject.getPrincipal();
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            // 角色与权限字符串集合
            Collection<String> rolesCollection = new HashSet<>();
            Collection<String> premissionCollection = new HashSet<>();

            Set<RoleBean> roles = user.getRole();
            for (RoleBean role : roles) {
                rolesCollection.add(role.getName());
                Set<PermissionBean> permissions = role.getPermissions();
                for (PermissionBean permission : permissions) {
                    premissionCollection.add(permission.getUrl());
                }
                info.addStringPermissions(premissionCollection);
            }
            info.addRoles(rolesCollection);
            return info;
        }
        return null;
    }

    /**
     * @param authenticationToken 用户的账号密码
     * @return AuthenticationInfo 用户身份信息(账号密码)
     * @throws AuthenticationException
     * @Description 认证操作
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        log.info("执行认证");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserBean bean = userService.findByName(token.getUsername());
        if (bean == null) {
            throw new UnknownAccountException();
        }
        ByteSource credentialsSalt = ByteSource.Util.bytes(bean.getName());
        return new SimpleAuthenticationInfo(bean, bean.getPassword(), credentialsSalt, this.getName());
    }

    /**
     * 模拟注册
     *
     * @param args
     */
    public static void main(String[] args) {
        String hashAlgorithName = "MD5";
        String password = "123456";
        int hashIterations = 1024;
        ByteSource credentialsSalt = ByteSource.Util.bytes("vip");
        Object obj = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
        System.out.println(obj);
    }
}