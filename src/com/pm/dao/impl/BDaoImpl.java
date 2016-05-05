package com.pm.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pm.dao.BDao;
@Repository("bDao")
@SuppressWarnings("all")
public class BDaoImpl<T> implements BDao<T>{
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public void update(T o){
		this.getCurrentSession().update(o);
	}
	public void saveOrUpdate(Object o) {
		this.getCurrentSession().saveOrUpdate(o);
	}
	public void delete(Object o) {
		this.getCurrentSession().delete(o);
	}
	public Serializable save(Object o) {
		return this.getCurrentSession().save(o);
	}
	public List<T> find(String sql) {
		return this.getCurrentSession().createQuery(sql).list();
	}
	public List<T> find(String sql, Object[] obj) {
		Query q=this.getCurrentSession().createQuery(sql);
		if(obj!=null&&obj.length>0){
			for(int i=0;i<obj.length;i++){
				q.setParameter(i, obj[i]);
			}
		}
		return q.list();
	}
	public List<T> find(String sql,List<Object> obj) {
		Query q=this.getCurrentSession().createQuery(sql);
		if(obj!=null&&obj.size()>0){
			for(int i=0;i<obj.size();i++){
				q.setParameter(i, obj.get(i));
			}
		}
		return q.list();
	}
	public List<T> find(String sql, Object[] obj, Integer page, Integer rows) {
		return null;
	}
	public List<T> find(String sql, List<Object> obj, Integer page, Integer rows) {
		return null;
	}
	public T get(Class c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}
	public T get(String sql, Object[] obj) {
		List<T> l=this.find(sql,obj);
		if(l!=null&&l.size()>0){
			return l.get(0);
		}
		else{
			return null;
		}
	}
	public Object get(String sql, List obj) {
		List<T> l=this.find(sql,obj);
		if(l!=null&&l.size()>0){
			return l.get(0);
		}
		else{
			return null;
		}
	}
	public Integer executeSql(String sql) {
		return this.getCurrentSession().createQuery(sql).executeUpdate();
	}
	public Integer executeSql(String sql, Object[] obj) {
		Query q=this.getCurrentSession().createQuery(sql);
		if(obj!=null&&obj.length>0){
			for(int i=0;i<obj.length;i++){
				q.setParameter(i, obj[i]);
			}
		}
		return q.executeUpdate();
	}
	public Integer executeSql(String sql, List<Object> obj) {
		Query q=this.getCurrentSession().createQuery(sql);
		if(obj!=null&&obj.size()>0){
			for(int i=0;i<obj.size();i++){
				q.setParameter(i, obj.get(i));
			}
		}
		return q.executeUpdate();
	}
}
