package com.myitconfig.shiro.service;


import com.myitconfig.shiro.pojo.UserBean;

public interface UserService {

    UserBean findByName(String name);
}
