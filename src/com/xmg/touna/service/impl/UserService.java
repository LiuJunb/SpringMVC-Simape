package com.xmg.touna.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmg.touna.dao.IUserDao;
import com.xmg.touna.dao.impl.UserDao;
import com.xmg.touna.model.User;
import com.xmg.touna.service.IUserService;

@Service("userService")
public class UserService implements IUserService {
	
	@Autowired //@Resource(name="userDao")
	private IUserDao userDao;

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}
	
	

}
