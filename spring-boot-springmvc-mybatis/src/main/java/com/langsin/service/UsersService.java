package com.langsin.service;

import java.util.List;

import com.langsin.pojo.User;

public interface UsersService {
	
	void addUser(User users);
	
	List<User> findAllUsers();
	
	User findUserById(int id);
	
	void editUserById(User user);
	
	void cutUserById(int id);
}
