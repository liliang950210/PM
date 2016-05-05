package com.pm.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="project_resource")
public class ProjectResource {

	private Integer resourceId;
	private String projectId;
	private String resourceName;
	private String resourceDescription;
	private String resourceQuantity;
	private String resourceType;
	@Id
	@GenericGenerator(name="generator",strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="resource_id",length=4)
	public Integer getResourceId(){
		return this.resourceId;
	}
	public void setResourceId(Integer resourceId){
		this.resourceId=resourceId;
	}
	@Column(name="project_id",length=4)
	public String getProjectId(){
		return this.projectId;
	}
	public void setProjectId(String projectId){
		this.projectId=projectId;
	}
	@Column(name="resource_name",length=64)
	public String getResourceName(){
		return this.resourceName;
	}
	public void setResourceName(String resourceName){
		this.resourceName=resourceName;
	}
	@Column(name="resource_description",length=65536)
	public String getResourceDescription(){
		return this.resourceDescription;
	}
	public void setResourceDescription(String resourceDescription){
		this.resourceDescription=resourceDescription;
	}
	@Column(name="resource_quantity",length=4)
	public String getResourceQuantity(){
		return this.resourceQuantity;
	}
	public void setResourceQuantity(String resourceQuantity){
		this.resourceQuantity=resourceQuantity;
	}
	@Column(name="resource_type",length=1)
	public String getResourceType(){
		return this.resourceType;
	}
	public void setResourceType(String resourceType){
		this.resourceType=resourceType;
	}
}
