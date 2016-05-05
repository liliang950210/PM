package com.pm.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.util.SubsetIteratorFilter.Decider;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pm.service.ResourcesService;
import com.pm.table.ProjectResource;

/**
 * @author chuankun
 *下午1:12:24  2015年12月14日
 */
@Controller
public class ResourcesAction extends ActionSupport{
	@Resource
	private ResourcesService resourcesService;
	
	private String resourceId;
	private String name ;
	private String desc;
	private String projectId="3";
	private String roleId;

	private String quantity;
	private String type;//错误信息提示
	private String tag;
	/**
	 * 增加一个资源
	 * @return
	 */
	/**
	 * @return
	 */
	public String add(){
		if(name.equalsIgnoreCase("")){
			ActionContext.getContext().getSession().put("tag", "请输入资源名字");
			return SUCCESS;
		}
		if(quantity.equalsIgnoreCase("")){
			quantity="0";
		}
		if(desc.equalsIgnoreCase("")){
			desc=" ";
		}
		int count=0;
		for(ProjectResource res:resourcesService.findOne(projectId, type, name)){
			count++;
		}
		if(count!=0){
			ActionContext.getContext().getSession().put("tag", "该资源已存在！");
			return SUCCESS;
		}
		else{
			ActionContext.getContext().getSession().put("tag", null);
		}
		ProjectResource res= new ProjectResource();
		res.setProjectId(projectId);;
		res.setResourceName(name);
		res.setResourceDescription(desc);
		res.setResourceQuantity(quantity);
		res.setResourceType(type);
		resourcesService.add(res);
		show();
		return SUCCESS;
	}

	/**
	 * 删除某个资源
	 * @return
	 */
	public String delete() {
//		if(name==""){
//			ActionContext.getContext().getSession().put("tag", "请输入资源名字");
//			return SUCCESS;
//		}
		ProjectResource resource = resourcesService.findById(projectId, resourceId);
		resourcesService.delete(resource);
//		int count=0;
//		for(ProjectResource res:list){
//			count++;
//			resourcesService.delete(res);
//		}
//		if(count==0){
//			ActionContext.getContext().getSession().put("tag", "输入的资源不存在！");
//		}
		show();
		return SUCCESS;
		
	}
	public String update() {
//		if(name.equalsIgnoreCase("")){
//			ActionContext.getContext().getSession().put("tag", "请输入资源名字");
//			return SUCCESS;
//		}
		if(quantity.equalsIgnoreCase("")){
			quantity="0";
		}
		if(desc.equalsIgnoreCase("")){
			desc=" ";
		}
//		for(ProjectResource res:resourcesService.findOne(projectId, type, name)){
//			resourcesService.delete(res);
//		}
		
		ProjectResource res= new ProjectResource();
		if(!resourceId.equalsIgnoreCase("")){
			res.setResourceId(Integer.valueOf(resourceId));
		}
		res.setProjectId(projectId);;
		res.setResourceName(name);
		res.setResourceDescription(desc);
		res.setResourceQuantity(quantity);
		res.setResourceType(type);
		resourcesService.add(res);
		show();
		return SUCCESS;
		
	}
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		show();
		return SUCCESS;
	}
	//用于页面的跳转
	public String change() {
		return SUCCESS;
		
	}
	
	/**
	 * 用于显示
	 */
	
	public void show(){
		List<ProjectResource> list = resourcesService.findAll(projectId, "2");
		ActionContext.getContext().getSession().put("list0", list);
		list = resourcesService.findAll(projectId, "1");
		ActionContext.getContext().getSession().put("list1", list);
		list= resourcesService.findAll(projectId, "0");
		ActionContext.getContext().getSession().put("list2", list);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	

}
