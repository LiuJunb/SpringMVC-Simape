package com.xmg.touna.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.touna.model.Config;
import com.xmg.touna.model.User;
import com.xmg.touna.service.IConfigService;
import com.xmg.touna.service.IUserService;
import com.xmg.touna.service.impl.UserService;

@Controller
@RequestMapping("/config")
public class ConfigController {

	@Autowired //@Resource(name="userService")
	private IConfigService configService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@ResponseBody
	public String getUsers(String counts) {
		List<Config> all = configService.getAll();
	    return all.toString();
	}

}
