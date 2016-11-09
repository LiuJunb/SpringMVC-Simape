package com.xmg.touna.base;

import java.util.List;

public interface IBaseDAO<T> {
	//添加实体
	int insert(T t);
	//批量添加实体
	int batchInsert(List<T> tList);
	//更新实体
	int update(T t);
	//查询单个实体
	T getOneById(Long id);
	//查询所有
	List<T> getAll();
	//删除单实体
	int remove(Long id);
	//删除多实体
	int removeBatch(List<Long> idList);	
	
}
