package com.bjsxt.sorm.core;


/**
 * 负责针对Mysql数据库的查询
 * @author gaoqi
 *
 */
public class MySqlQuery extends Query {
	
	

	/*
	 * MySql特有功能  和其他数据库的分页查询不同 ，分页查询 
	 */
	
	@Override
	public Object queryPagenate(int pageNum, int size) {
		// TODO Auto-generated method stub
		return null;
	}
	


	

}
