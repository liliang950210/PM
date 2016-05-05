package com.pm.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="project_scope")
public class ProjectScope {

	private Integer scopeId;
	private String projectId;
	private String scopeStart;
	private String scopePlan;
	private String scopeDefinition;
	private String scopeConfirm;
	private String scopeChange;
	@Id
	@GenericGenerator(name="generator",strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="scope_id",length=4)
	public Integer getScopeId(){
		return this.scopeId;
	}
	public void setScopeId(Integer scopeId){
		this.scopeId=scopeId;
	}
	@Column(name="project_id",length=4)
	public String getProjectId(){
		return this.projectId;
	}
	public void setProjectId(String projectId){
		this.projectId=projectId;
	}
	@Column(name="scope_start",length=65536)
	public String getScopeStart(){
		return this.scopeStart;
	}
	public void setScopeStart(String scopeStart){
		this.scopeStart=scopeStart;
	}
	@Column(name="scope_plan",length=65536)
	public String getScopePlan(){
		return this.scopePlan;
	}
	public void setScopePlan(String scopePlan){
		this.scopePlan=scopePlan;
	}
	@Column(name="scope_definition",length=65536)
	public String getScopeDefinition(){
		return this.scopeDefinition;
	}
	public void setScopeDefinition(String scopeDefinition){
		this.scopeDefinition=scopeDefinition;
	}
	@Column(name="scope_confirm",length=65536)
	public String getScopeConfirm(){
		return this.scopeConfirm;
	}
	public void setScopeConfirm(String scopeConfirm){
		this.scopeConfirm=scopeConfirm;
	}
	@Column(name="scope_change",length=65536)
	public String getScopeChange(){
		return this.scopeChange;
	}
	public void setScopeChange(String scopeChange){
		this.scopeChange=scopeChange;
	}
}
