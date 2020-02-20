package com.myitconfig.shiro.mapper;

import com.myitconfig.shiro.pojo.UserBean;
import org.apache.ibatis.annotations.Mapper;

public interface UserMapper {

    UserBean findByName(String name);

    UserBean findById(String id);
}