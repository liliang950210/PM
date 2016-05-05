package com.pm.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="project_cost")
public class ProjectCost {

	private Integer costId;
	private String projectId;
	private String costItem;
	private String costExpense;
	private String costDescription;
	@Id
	@GeneratedValue(generator="generator")
	@GenericGenerator(name="generator",strategy="increment")
	@Column(name="cost_id",length=4)
	public Integer getCostId(){
		return this.costId;
	}
	public void setCostId(Integer costId){
		this.costId=costId;
	}
	@Column(name="projecct_id",length=4)
	public String getProjectId(){
		return this.projectId;
	}
	public void setProjectId(String projectId){
		this.projectId=projectId;
	}
	@Column(name="cost_item",length=16)
	public String getCostItem(){
		return this.costItem;
	}
	public void setCostItem(String costItem){
		this.costItem=costItem;
	}
	@Column(name="cost_expense",precision=12,scale=2)
	public String getCostExpense(){
		return this.costExpense;
	}
	public void setCostExpense(String costExpense){
		this.costExpense=costExpense;
	}
	@Column(name="cost_description",length=65536)
	public String getCostDescription(){
		return this.costDescription;
	}
	public void setCostDescription(String costDescription){
		this.costDescription=costDescription;
	}
}
