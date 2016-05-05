package com.pm.table;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="edition")
public class Edition {

	private Integer editionId;
	private String projectId;
	private String editionDescription;
	private Date editionTime;
	private String codePath;
	private String editionNumber;
	@Id
	@GenericGenerator(name="generator",strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="edition_id",length=4)
	public Integer getEditionId(){
		return this.editionId;
	}
	public void setEditionId(Integer editionId){
		this.editionId=editionId;
	}
	@Column(name="project_id",length=4)
	public String getProjectId(){
		return this.projectId;
	}
	public void setProjectId(String projectId){
		this.projectId=projectId;
	}
	@Column(name="edition_number",length=16)
	public String getEditionNumber(){
		return this.editionNumber;
	}
	public void setEditionNumber(String editionNumber){
		this.editionNumber=editionNumber;
	}
	@Column(name="edition_description",length=65536)
	public String getEditionDescription(){
		return this.editionDescription;
	}
	public void setEditionDescription(String editionDescription){
		this.editionDescription=editionDescription;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="edition_time")
	public Date getEditionTime(){
		return this.editionTime;
	}
	public void setEditionTime(Date editionTime){
		this.editionTime=editionTime;
	}
	@Column(name="code_path",length=100)
	public String getCodePath(){
		return this.codePath;
	}
	public void setCodePath(String codePath){
		this.codePath=codePath;
	}
}
