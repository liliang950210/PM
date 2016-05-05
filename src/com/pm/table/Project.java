package com.pm.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="project")
public class Project {

	private Integer projectId;
	private String projectName;
	private String projectDescription;
	@Id
	@GenericGenerator(name="generator",strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="project_id",length=4)
	public Integer getProjectId(){
		return this.projectId;
	}
	public void setProjectId(Integer projectId){
		this.projectId=projectId;
	}
	@Column(name="project_name",length=16)
	public String getProjectName(){
		return this.projectName;
	}
	public void setProjectName(String projectName){
		this.projectName=projectName;
	}
	@Column(name="project_description",length=65536)
	public String getProjectDescription(){
		return this.projectDescription;
	}
	public void setProjectDescription(String projectDescription){
		this.projectDescription=projectDescription;
	}
}
