package com.pm.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pm.service.ScopeService;
import com.pm.table.ProjectScope;

/**
 * 执行确认修改的操作
 * @author JiangLongwei
 * @date 2015年12月9日
 */
@Controller
public class ScopeChangeConfirmAction extends ActionSupport{

	private String projectId;
	private int roleId;
	private ProjectScope projectScope;
	
	@Resource
	private ScopeService scopeService;
	
	public String confirmScope(){
		

		scopeService.updateProjectScope(getProjectScope());
		

		setProjectScope(getProjectScope());
		setRoleId(1);
		
		return SUCCESS;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public ProjectScope getProjectScope() {
		return projectScope;
	}

	public void setProjectScope(ProjectScope projectScope) {
		this.projectScope = projectScope;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
}
