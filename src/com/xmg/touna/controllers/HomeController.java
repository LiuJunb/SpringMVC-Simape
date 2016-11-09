package com.xmg.touna.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.touna.model.Product;
import com.xmg.touna.model.User;
import com.xmg.touna.service.IProductService;
import com.xmg.touna.service.IUserService;
import com.xmg.touna.service.impl.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	

	@Autowired //@Resource(name="userService")
	private IProductService productService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@ResponseBody
	public String getHomeList(String counts) {
		Product all = productService.getOneById(2l);
	    return all.toString();
	}
	

}
