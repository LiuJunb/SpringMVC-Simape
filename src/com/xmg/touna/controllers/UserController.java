package com.xmg.touna.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.touna.model.User;
import com.xmg.touna.service.IUserService;
import com.xmg.touna.service.impl.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	

	@Autowired //@Resource(name="userService")
	private IUserService userService;
	
	@RequestMapping(value = "/getUser",method = RequestMethod.GET)
	@ResponseBody
	public String getUsers(String counts) {
		List<User> all = userService.getAll();
	    return all.toString();
	}

}
