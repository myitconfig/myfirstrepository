package com.myitconfig.shiro.service.impl;

import com.myitconfig.shiro.mapper.UserMapper;
import com.myitconfig.shiro.pojo.UserBean;
import com.myitconfig.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;//此处爆红为spring注解声明问题,不影响运行

    @Override
    public UserBean findByName(String name) {
        UserBean bean = userMapper.findByName(name);
        if (bean != null) {
            bean = userMapper.findById(bean.getId());
        }
        return bean;
    }
}