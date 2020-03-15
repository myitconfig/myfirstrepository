package com.langsin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.langsin.pojo.User;
import com.langsin.service.impl.UsersServiceImpl;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersServiceImpl usersServiceImpl;
	/**
	 * 页面跳转
	 */
	@RequestMapping("/{page}")
	public String tranPage(@PathVariable String page,User users) {
		return page;
	}
	/**
	 * 添加用户
	 */
	@RequestMapping("/addusers")
	public String addUsers(@Valid User users,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "input";
		}else {
			this.usersServiceImpl.addUser(users);
			return "ok";
		}
		
	}
	/**
	 * 查询所有用户
	 */
	@RequestMapping("/allusers")
	public String showAllUsers(Model model) {
		List<User> allUsersList=this.usersServiceImpl.findAllUsers();
		model.addAttribute("allUsersList", allUsersList);
		return "show";
	}
	/**
	 * 查询单个用户
	 */
	@RequestMapping("/selectsingleuser")
	public String selectSingleUser(Model model,int id) {
		model.addAttribute("singleUser", this.usersServiceImpl.findUserById(id));
		return "singleuserpage";
	}
	/**
	 * 更新用户信息
	 */
	@RequestMapping("/updateuser")
	public String updateUser(User user) {
		this.usersServiceImpl.editUserById(user);
		return "ok";
	}
	/**
	 * 单个删除用户
	 */
	@RequestMapping("/deleteuser")
	public String deleteUser(int id) {
		this.usersServiceImpl.cutUserById(id);
		return "redirect:/users/allusers";
	}
















}
