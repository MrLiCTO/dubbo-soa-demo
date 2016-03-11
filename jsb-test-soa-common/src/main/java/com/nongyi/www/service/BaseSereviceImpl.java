package com.nongyi.www.service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BaseSereviceImpl<T> extends SqlSessionDaoSupport implements BaseService<T>{

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	private String ns;		//命名空间
	private String nscus;		//自定义命名空间
	public String getNs() {
		return ns;
	}
	public void setNs(String ns) {
		this.ns = ns;
	}
	
	public String getNscus() {
		return nscus;
	}
	public void setNscus(String nscus) {
		this.nscus = nscus;
	}

	public T getById(Serializable id) {
		return this.getSqlSession().selectOne(ns + ".selectByPrimaryKey", id);
	}

	public void save(T entity) {
		this.getSqlSession().insert(ns + ".insert", entity);
	}

	public void update(T entity) {
		this.getSqlSession().update(ns + ".updateByPrimaryKey", entity);
	}

	public void deleteById(Serializable id) {
		this.getSqlSession().delete(ns + ".deleteByPrimaryKey", id);
	}

	/*public void delete(Serializable[] ids) {
		this.getSqlSession().delete(nscus + ".delete", ids);
	}*/
	
	

}
