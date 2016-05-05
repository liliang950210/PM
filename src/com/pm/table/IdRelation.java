package com.pm.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="relation_id")
public class IdRelation {
	private Integer theId;
	private String userId;
	private String roleId;
	private String projectId;
	@Id
	@GenericGenerator(name="generator",strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="id",length=4)
	public Integer getTheId(){
		return this.theId;
	}
	public void setTheId(Integer theId){
		this.theId=theId;
	}
	@Column(name="user_id",length=4)
	public String getUserId(){
		return this.userId;
	}
	public void setUserId(String userId){
		this.userId=userId;
	}
	@Column(name="role_id",length=4)
	public String getRoleId(){
		return this.roleId;
	}
	public void setRoleId(String roleId){
		this.roleId=roleId;
	}
	@Column(name="project_id",length=4)
	public String getProjectId(){
		return this.projectId;
	}
	public void setProjectId(String projectId){
		this.projectId=projectId;
	}
}
