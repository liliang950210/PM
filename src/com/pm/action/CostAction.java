package com.pm.action;


import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pm.service.CostService;
import com.pm.table.ProjectCost;
/**
 * @author chuankun
 *下午1:12:29  2015年12月14日
 */
@Controller
public class CostAction extends ActionSupport{
	
	
	
	@Resource
	private CostService costServer;
	
	private String addName;
	private String deleteName;
	private String costId; 
	private String roleId;
	
	private String cost;
	private String desc;
	private String tag;
	//用于获取projectId
//	private String project_id = ActionContext.getContext().getSession().get("projectId").toString();
	private String projectId="3";
	private List<ProjectCost> list ;
	
	/**
	 * 增加一个记录
	 * @return
	 */
	public String add() {
		if(addName.equalsIgnoreCase("")){
			tag = "名字为空！";
			ActionContext.getContext().getSession().put("tag", tag);
			return SUCCESS;
		}else if(cost.equalsIgnoreCase("")){
			cost="0";
		}else if(desc.equals("")){
			desc=" ";
		}
		int count=0;
		for(ProjectCost cost:costServer.findOne(addName,projectId)){
			count++;
		}
		if(count!=0){
			ActionContext.getContext().getSession().put("tag", "用户名已存在，请重新输入！");
			return SUCCESS;
		}
		else{
			ActionContext.getContext().getSession().put("tag", null);
		}
		ProjectCost project_cost = new ProjectCost();
		project_cost.setCostItem(addName);
		project_cost.setProjectId(projectId);
		project_cost.setCostExpense(cost);
		project_cost.setCostDescription(desc);
		costServer.addCost(project_cost);
		list= costServer.findAll(projectId);
		ActionContext.getContext().getSession().put("list",list);
		return SUCCESS;
		
	}
	
	public String delete(){
//		if(deleteName.equals("")){
//			tag="请输入名字！";
//		}
//		List<ProjectCost > list = costServer.findOne(deleteName,project_id);
//		for(ProjectCost cost:list){
//		costServer.deleteCost(cost);
//		}
		ProjectCost cost= costServer.findById(projectId,costId );
		costServer.deleteCost(cost);
		list= costServer.findAll(projectId);
		ActionContext.getContext().getSession().put("list",list);
		return SUCCESS;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
		
	}
	
	public String  update() {
		if(addName.equals("")){
			tag = "名字为空！";
			ActionContext.getContext().getSession().put("tag", tag);
			return SUCCESS;
		}else if(cost.equals("")){
			cost="0";
		}else if(desc.equals("")){
			desc=" ";
		}
//		List<ProjectCost > list = costServer.findOne(addName,projectId);
//		for(ProjectCost cost:list){
//		costServer.deleteCost(cost);
//		}
		
		ProjectCost project_cost= new ProjectCost();
		if(!costId.equals("")){
			project_cost.setCostId(Integer.valueOf(costId));
		}
		project_cost.setCostItem(addName);
		project_cost.setProjectId(projectId);
		project_cost.setCostExpense(cost);
		project_cost.setCostDescription(desc);
		costServer.updateOne(project_cost);
		list= costServer.findAll(projectId);
		ActionContext.getContext().getSession().put("list",list);
		return SUCCESS;
		
	}
	//默认的函数用于开始的时候显示页面
	@Override
	public String execute() throws Exception {
		list= costServer.findAll(projectId);
		ActionContext.getContext().getSession().put("list",list);
		return SUCCESS;
	}
	
	//当用户点击更新或增加的时候用于页面的跳转
	public String change() {
		
		return SUCCESS;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getAddName() {
		return addName;
	}

	public void setAddName(String addName) {
		this.addName = addName;
	}

	public String getDeleteName() {
		return deleteName;
	}

	public void setDeleteName(String deleteName) {
		this.deleteName = deleteName;
	}
	public void setProjectId(String project_id){
		this.projectId= project_id;
	}
	public String getProjectId() {
		return this.projectId;
		
	}
	public String getCostId() {
		return costId;
	}

	public void setCostId(String costId) {
		this.costId = costId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
}
