package com.pm.dao;

import java.io.Serializable;
import java.util.List;

public interface BDao<T> {
	public void delete(T o);
	public void update(T o);
	public Serializable save(T o);
	public void saveOrUpdate(T o);
	public List<T> find(String sql);
	public List<T> find(String sql,Object[]obj);
	public List<T> find(String sql,List<Object>obj);
	public List<T> find(String sql,Object[]obj,Integer page,Integer rows);/* page设置第几页的内容，rows设置一页显示多少行记录 */
	public List<T> find(String sql,List<Object>obj,Integer page,Integer rows);/* page设置第几页的内容，rows设置一页显示多少行记录 */
	public T get(Class<T> c,Serializable id);
	public T get(String sql,Object[]obj);
	public T get(String sql,List<Object>obj);
	public Integer executeSql(String sql);
	public Integer executeSql(String sql,Object[]obj);
	public Integer executeSql(String sql,List<Object>obj);
}
