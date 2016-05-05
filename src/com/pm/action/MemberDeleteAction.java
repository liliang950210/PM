package com.pm.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.pm.bean.UserBean;
import com.pm.service.RelationService;
import com.pm.service.RoleService;
import com.pm.service.TaskService;
import com.pm.service.UserService;
import com.pm.table.IdRelation;
import com.pm.table.Role;
import com.pm.table.User;

/**
 * 删除项目成员，将会影响所有相关的计划安排
 * 
 * @author JiangLongwei
 * @date 2015年12月8日
 */
public class MemberDeleteAction extends ActionSupport {

	private List<UserBean> userBeans;
	private String projectId;

	private int roleId;
	private String userId;

	@Resource
	private RelationService relationService;
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	@Resource
	private TaskService taskService;

	public String deleteMember() {

		List<IdRelation> relations = relationService
				.findRelationsByProjectId(getProjectId());

		int size = relations.size();

		List<UserBean> users = new ArrayList<UserBean>();
		// 查找相应的userName 以及角色出来噢
		for (int i = 0; i < size; i++) {

			User user = userService.findUserById(Integer.parseInt(relations
					.get(i).getUserId()));
			Role role = roleService.findRoleById(Integer.parseInt(relations
					.get(i).getRoleId()));

			if (user == null || role == null) {
				continue;
			}

			if (user.getId() == Integer.parseInt(getUserId())) {
				// 不添加到列表中,直接删除掉
				relationService.deleteRelation(relations.get(i));
				// 删除对应userId的task内容
				taskService.deleteTasksByUserId(getUserId());
				continue;
			}

			UserBean userBean = new UserBean();

			userBean.setId(user.getId());
			userBean.setUsername(user.getUsername());
			userBean.setRoleId(role.getRoleId());
			userBean.setRole(role.getRoleName());
			userBean.setIsChange(1);
			users.add(userBean);
		}

		setUserBeans(users);
		setRoleId(1);
		return SUCCESS;

	}

	public List<UserBean> getUserBeans() {
		return userBeans;
	}

	public void setUserBeans(List<UserBean> userBeans) {
		this.userBeans = userBeans;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
