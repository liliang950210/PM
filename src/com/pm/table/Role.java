package com.pm.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="role")
public class Role {

	private Integer roleId;
	private String roleName;
	@Id
	@GenericGenerator(name="generator",strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="role_id",length=4)
	public Integer getRoleId(){
		return this.roleId;
	}
	public void setRoleId(Integer roleId){
		this.roleId=roleId;
	}
	@Column(name="role_name",length=16)
	public String getRoleName(){
		return this.roleName;
	}
	public void setRoleName(String roleName){
		this.roleName=roleName;
	}
}
