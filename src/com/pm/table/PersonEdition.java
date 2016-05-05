package com.pm.table;

import java.security.Timestamp;
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
@Table(name="person_edition")
public class PersonEdition {

	private Integer personEditionId;
	private String editionId;
	private String userId;
	private Date personEditionTime;
	private String personEditionPath;
	@Id
	@GenericGenerator(name="generator",strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="person_edition_id",length=4)
	public Integer getPersonEditionId(){
		return this.personEditionId;
	}
	public void setPersonEditionId(Integer personEditionId){
		this.personEditionId=personEditionId;
	}
	@Column(name="edition_id",length=4)
	public String getEditionId(){
		return this.editionId;
	}
	public void setEditionId(String editionId){
		this.editionId=editionId;
	}
	@Column(name="user_id",length=4)
	public String getUserId(){
		return this.userId;
	}
	public void setUserId(String userId){
		this.userId=userId;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sub_time")
	public Date getPersonEditionTime(){
		return this.personEditionTime;
	}
	public void setPersonEditionTime(Date nousedate){
		this.personEditionTime=nousedate;
	}
	@Column(name="person_code_path",length=100)
	public String getPersonEditionPath(){
		return this.personEditionPath;
	}
	public void setPersonEditionPath(String personEditionPath){
		this.personEditionPath=personEditionPath;
	}
}
