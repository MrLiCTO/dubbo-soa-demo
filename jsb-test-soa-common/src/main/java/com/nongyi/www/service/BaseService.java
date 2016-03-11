package com.nongyi.www.service;

import java.io.Serializable;

public interface BaseService<T> {
	
	//public List<T> findPage(Page page);				//分页查询
	//public List<T> find(Map paraMap);				//带条件查询，条件可以为null，既没有条件；返回list对象集合
	
	public T getById(Serializable id);					//只查询一个，常用于修改
	public void save(T entity);					//插入，用实体作为参数
	public void update(T entity);					//修改，用实体作为参数
	public void deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	
}
