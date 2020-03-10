package com.myitconfig.shiro.config;

import com.myitconfig.shiro.shirorealm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {

    /**
     * @return HashedCredentialsMatcher
     * @Description 设置MD5加密方式
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    /**
     * @param matcher
     * @return userRealm 自定义realm连接器
     * @Description 创建自定义Realm
     */
    @Bean
    public UserRealm userRealm(HashedCredentialsMatcher matcher) {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }

    /**
     * @param hashedCredentialsMatcher 传入MD5加密方法
     * @return securityManager安全管理器
     * @Description 注入DefaultWebSecurityManager默认安全管理器
     */
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(HashedCredentialsMatcher hashedCredentialsMatcher) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm(hashedCredentialsMatcher));
        return securityManager;
    }

    /**
     * @param securityManager 传入securityManager
     * @return shiro自带过滤器工厂bean
     * @Description 创建shiro过滤器工厂bean
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager); // 设置 SecurityManager
        bean.setSuccessUrl("/main");//设置登录成功页面
        bean.setLoginUrl("/toLogin"); // 设置登录跳转页面
        bean.setUnauthorizedUrl("/error/unAuth"); // 设置未授权提示页面
        /**
         * Shiro内置过滤器，可以实现拦截器相关的拦截器
         *    常用的过滤器：
         *      anon     无需认证（登录）可以访问
         *      authc   必须认证才可以访问
         *      user     如果使用rememberMe的功能可以直接访问
         *      perms  该资源必须得到资源权限才可以访问
         *      role     该资源必须得到角色权限才可以访问
         **/
        Map<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/login", "anon");
        filterMap.put("/user/index", "authc");
        filterMap.put("/vip/index", "roles[vip]");
        filterMap.put("/druid/**", "anon");
        filterMap.put("/static/**", "anon");

        filterMap.put("/**", "authc");
        filterMap.put("/logout", "logout");

        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }


    /**
     * @param securityManager 传入安全管理器
     * @return authorizationAttributeSourceAdvisor
     * @Description 开启注解
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}