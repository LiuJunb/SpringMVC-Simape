package com.xmg.touna.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmg.touna.dao.IUserDao;
import com.xmg.touna.model.User;

@Service("userDao") 
public class UserDao implements IUserDao{

	@Autowired
    private SqlSessionTemplate sqlSession;
	
	@Override
	public List<User> getAll() {
//		List<User> list=new ArrayList<>();
//		list.add(new User(1l,"liujun","123456"));
		List<User> selectList = sqlSession.selectList("com.xmg.touna.dao.mappers.UserMapper.getAll");
		return selectList;
	}

}
