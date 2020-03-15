package com.langsin;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.langsin.pojo.User;
import com.langsin.service.impl.UsersServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class TestEhcache {
	
	@Autowired
	UsersServiceImpl usersServiceImpl;
	
	@Test
	public void testFindAllUsers() {
		List<User> userList=this.usersServiceImpl.findAllUsers();
		for (User user : userList) {
			System.out.println(user.toString());
		}
		
		User user=new User();
		user.setName("杨过");
		user.setAge(20);
		this.usersServiceImpl.addUser(user);
		
		List<User> userList1=this.usersServiceImpl.findAllUsers();
		for (User user1 : userList1) {
			System.out.println(user1.toString());
		}
	}
	
	@Test
	public void testAddUser() {
		
	}
	
}
