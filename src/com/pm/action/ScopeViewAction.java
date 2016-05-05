package com.pm.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pm.service.ScopeService;
import com.pm.service.UserService;
import com.pm.table.ProjectScope;

/**
 * 
 * @author JiangLongwei
 * @date 2015年12月4日
 */
@Controller
public class ScopeViewAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String projectId;
	private int roleId;

	@Resource
	private ScopeService scopeService;

	private ProjectScope projectScope;

	/**
	 * 查看范围，返回对应过去的页面文件
	 * 
	 * @return
	 */
	public String viewScope() {

//		System.out.println("获取到的roleId为"+getRoleId());
		ProjectScope scope = scopeService.findScopeByProjectId(getProjectId());

		setProjectScope(scope);
		setRoleId(getRoleId());
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
