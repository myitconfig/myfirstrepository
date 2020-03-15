package com.langsin.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.langsin.pojo.UserInfo;

@Controller
public class FirstController {
	@RequestMapping("hello")
	public Map<String, String> testMap(){
		Map<String, String> map=new HashMap<>();
		map.put("msg", "获取用户信息");
		return map;
	}
	@RequestMapping("fileUploadController")
	@ResponseBody
	public Map<String, Object> fileUpload(MultipartFile filename)throws Exception{
		System.out.println(filename.getOriginalFilename());
		filename.transferTo(new File("e:/"+filename.getOriginalFilename()));
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "上传成功");
		return map;
	} 
	/**
	 * 测试Thymeleaf
	 */
	@RequestMapping("mypage")
	public String testThymeleaf(Model model,HttpServletRequest request) {
		model.addAttribute("msg","展示个人信息");
		model.addAttribute("date", new Date());
		model.addAttribute("sex", "男");
		model.addAttribute("id", "2");
		
		List<UserInfo> userInfoList=new ArrayList<>();
		userInfoList.add(new UserInfo("耿策","男","汉","1995-11-26",175,70,"玩游戏"));
		userInfoList.add(new UserInfo("宋秋香","女","汉","1995-07-25",168,60,"旅游"));
		userInfoList.add(new UserInfo("耿策","男","汉","1995-11-26",175,70,"玩游戏"));
		userInfoList.add(new UserInfo("宋秋香","女","汉","1995-07-25",168,60,"旅游"));
		userInfoList.add(new UserInfo("宋秋香","女","汉","1995-07-25",168,60,"旅游"));
		userInfoList.add(new UserInfo("宋秋香","女","汉","1995-07-25",168,60,"旅游"));
		model.addAttribute("userInfoList", userInfoList);
		
		Map<String, UserInfo> userInfoMap=new HashMap<>();
		userInfoMap.put("vip", new UserInfo("耿策","男","汉","1995-11-26",175,70,"玩游戏"));
		userInfoMap.put("general", new UserInfo("宋秋香","女","汉","1995-07-25",168,60,"旅游"));
		model.addAttribute("userInfoMap", userInfoMap);
		
		request.setAttribute("req", "request携带数据");
		
		return "mypage";
	}
	@RequestMapping(value = "userinfo",method = RequestMethod.GET)
	public String getUserInfo(Model model,@PathParam("userName") String userName) {
	
		if (userName.equals("耿策")) {
			List<UserInfo> userInfoList0=new ArrayList<>();
			userInfoList0.add(new UserInfo("耿策","男","汉","1995-11-26",175,70,"玩游戏"));
			userInfoList0.add(new UserInfo("宋秋香","女","汉","1995-07-25",168,60,"旅游"));
			userInfoList0.add(new UserInfo("耿策","男","汉","1995-11-26",175,70,"玩游戏"));
			userInfoList0.add(new UserInfo("宋秋香","女","汉","1995-07-25",168,60,"旅游"));
			userInfoList0.add(new UserInfo("宋秋香","女","汉","1995-07-25",168,60,"旅游"));
			userInfoList0.add(new UserInfo("宋秋香","女","汉","1995-07-25",168,60,"旅游"));
			model.addAttribute("userInfoList0", userInfoList0);
		}
		return "userpage";
	}
	@RequestMapping("/personal/{userName}")
	public String getPersonalPage(Model model,@PathVariable("userName") String userName) {
		List<UserInfo> userInfoList0=new ArrayList<>();
		if (userName.equals("耿策")) {
			userInfoList0.add(new UserInfo("耿策","男","汉","1995-11-26",175,70,"玩游戏"));
			userInfoList0.add(new UserInfo("耿策","男","汉","1995-11-26",175,70,"玩游戏"));
			model.addAttribute("userInfoList0", userInfoList0);
		}else if(userName.equals("宋秋香")){
			userInfoList0.add(new UserInfo("宋秋香","女","汉","1995-07-25",168,60,"旅游"));
			userInfoList0.add(new UserInfo("宋秋香","女","汉","1995-07-25",168,60,"旅游"));
			userInfoList0.add(new UserInfo("宋秋香","女","汉","1995-07-25",168,60,"旅游"));
			userInfoList0.add(new UserInfo("宋秋香","女","汉","1995-07-25",168,60,"旅游"));
		}
		
		return "userpage";
	}
	/**
	 * 异常方法一
	 */
	@RequestMapping("/exception1")
	public String exceptionTest1() {
		String str=null;
		str.length();
		return "ok";
		
		
		
		
		
		
	}
	
	
	/**
	 * 异常处理
	 */
	@ExceptionHandler(value = java.lang.NullPointerException.class)
	public ModelAndView dealException(Exception e) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("error",e.toString());
		mv.setViewName("error1");
		return mv; 
	}
	
	
	
	
	
	
	
	
	
	
	
}
