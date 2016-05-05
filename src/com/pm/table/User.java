package com.pm.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
public class User {

	private Integer id;
	private String username;
	private String password;
	@Id
	@GenericGenerator(name="generator",strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="user_id",length=4)
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	@Column(name="user_name",length=16)
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	@Column(name="user_password",length=16)
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password=password;
	}
}
