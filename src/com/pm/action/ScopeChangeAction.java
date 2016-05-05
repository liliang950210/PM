package com.pm.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pm.service.ScopeService;
import com.pm.table.ProjectScope;

/**
 * 跳转至范围改变页面
 * 
 * @author JiangLongwei
 * @date 2015年12月9日
 */
@Controller
public class ScopeChangeAction extends ActionSupport {

	private String projectId;
	private ProjectScope projectScope;

	@Resource
	private ScopeService scopeService;

	public String changeScope() {

		ProjectScope scope = scopeService.findScopeByProjectId(getProjectId());


		setProjectScope(scope);

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

}
