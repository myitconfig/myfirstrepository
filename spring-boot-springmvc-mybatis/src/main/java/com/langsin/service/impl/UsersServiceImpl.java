package com.langsin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.langsin.mapper.UsersMapper;
import com.langsin.pojo.User;
import com.langsin.service.UsersService;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersMapper usersMapper;
	
	@Override
	@CacheEvict(value = "users",allEntries = true)
	public void addUser(User users) {this.usersMapper.insertUser(users);}

	@Override
	@Cacheable(value = "users",key = "#root.methodName")
	public List<User> findAllUsers() {return this.usersMapper.queryAllUsers();}

	@Override
	public User findUserById(int id) {return this.usersMapper.queryUserById(id);}

	@Override
	public void editUserById(User user) {this.usersMapper.updateUserById(user);}

	@Override
	public void cutUserById(int id) {this.usersMapper.deleteUserById(id);}
    
	

}
