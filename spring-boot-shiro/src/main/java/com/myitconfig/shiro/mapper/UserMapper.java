package com.myitconfig.shiro.mapper;

import com.myitconfig.shiro.pojo.UserBean;

public interface UserMapper {

    UserBean findByName(String name);

    UserBean findById(String id);
}