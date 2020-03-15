package com.langsin.mapper;

import java.util.List;

import com.langsin.pojo.User;

public interface UsersMapper {
	
	void insertUser(User users);
	
	List<User> queryAllUsers();
	
	User queryUserById(int id);
	
	void updateUserById(User user);
	
	void deleteUserById(int id);
}
