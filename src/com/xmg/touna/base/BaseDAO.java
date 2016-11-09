package com.xmg.touna.base;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmg.touna.utils.ReflectionUtils;


@Service("baseDAO") 
public abstract class BaseDAO<T> {
	@Autowired
    private SqlSessionTemplate sqlSession;
	//mapper命名空间
	public static final String MAPPER_NAMESPACE = "com.xmg.touna.dao.mappers";
	public static final String NAMESPACE_CONTACTOR = ".";
	
	//class
	private Class<T> clazz;   
    
    @SuppressWarnings("unchecked")
	public BaseDAO(){    	 
        clazz=ReflectionUtils.getSuperClassGenricType(this.getClass());
        System.out.println(clazz.getName());
        System.out.println(this.getClass().getSimpleName());
	}
    
	//添加实体
	public int insert(T t){
		return sqlSession.insert(getMapper() + ".insert",t);
	}
	//批量添加实体
	public int batchInsert(List<T> tList){
    	return sqlSession.insert(getMapper() + ".batchInsert",tList); 
	}
	//更新实体
	public int update(T t){
    	return sqlSession.update(getMapper() + ".update",t); 
	}
	//查询单个实体
	public T getOneById(Long id){
		return sqlSession.selectOne(getMapper() + ".getOneById",id);
	}
	//查询所有
	public List<T> getAll(){
		System.out.println(sqlSession == null);
		return sqlSession.selectList(getMapper() + ".getAll");
	}
	//删除单实体
	public int remove(Long id){
		return sqlSession.delete(getMapper() + ".remove",id); 
	}
	//删除多实体
	public int removeBatch(List<Long> idList){
		return sqlSession.delete(getMapper() + ".removeBatch",idList);
	}
	
	public String getMapper(){
		return MAPPER_NAMESPACE + NAMESPACE_CONTACTOR + clazz.getSimpleName() + "Mapper";
	}
	/*public void setSqlSession(SqlSessionTemplate sqlSession){
		System.out.println("set sqlSession");
		this.sqlSession = sqlSession;
	}*/
	public SqlSessionTemplate getSqlSession() {
	    return this.sqlSession;
	}
}
