package com.xmg.touna.dao.mappers;

import java.util.List;

import com.xmg.touna.model.User;

public interface UserMapper {

	//查询单个实体
	User getOneById(String ds,Long id);
	//查询所有
	List<User> getAll();
	
}
