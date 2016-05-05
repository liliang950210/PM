package com.pm.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.pm.bean.UserBean;
import com.pm.service.RelationService;
import com.pm.service.RoleService;
import com.pm.service.UserService;
import com.pm.table.IdRelation;
import com.pm.table.Role;
import com.pm.table.User;

/**
 * 跳转到添加member的页面
 * 
 * @author JiangLongwei
 * @date 2015年12月8日
 */
public class MemberAddAction extends ActionSupport {

	private List<UserBean> userBeans;
	private String projectId;
	private String memberRoleId;
	private String userName;

	private String errorMsg;
	private int isAdd;

	private int roleId;

	@Resource
	private RelationService relationService;
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;

	public String addMember() {
		// 无非就是插入id_relation新项
		System.out.println("执行添加member的操作 projectId为" + getProjectId()
				+ " userName为：" + getUserName());

		// 标志可以进行保存操作
		boolean canSaveMember = true;
		User saveMember = userService.findUserByName(getUserName());
		if (saveMember == null) {
			setErrorMsg("所输入的用户不存在，请重新输入");
			canSaveMember = false;
			setIsAdd(1);
		}

		// 取数据
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
			// 对每一个user进行判断检查，如果有相同的，则不给添加
			if (canSaveMember && user.getId() == saveMember.getId()) {
				setErrorMsg("所输入的用户已经在项目中，请重新输入");
				canSaveMember = false;
				setIsAdd(1);
			}

			UserBean userBean = new UserBean();

			userBean.setId(user.getId());
			userBean.setUsername(user.getUsername());
			userBean.setRoleId(role.getRoleId());
			userBean.setRole(role.getRoleName());
			userBean.setIsChange(1);
			users.add(userBean);
		}

		if (canSaveMember) {
			// 执行保存操作咯
			setErrorMsg("");
			setIsAdd(0);

			IdRelation saveRelation = new IdRelation();
			saveRelation.setUserId(saveMember.getId() + "");
			saveRelation.setRoleId(getMemberRoleId());
			saveRelation.setProjectId(getProjectId());
			relationService.saveRelation(saveRelation);

			// 保存成功将新添加的一项添加到列表最后面

			Role addRole = roleService.findRoleById(Integer
					.parseInt(getMemberRoleId()));
			UserBean addBean = new UserBean();
			addBean.setId(saveMember.getId());
			addBean.setUsername(saveMember.getUsername());
			addBean.setRoleId(addRole.getRoleId());
			addBean.setRole(addRole.getRoleName());
			addBean.setIsChange(1);
			users.add(addBean);

		}

		setProjectId(getProjectId());
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getIsAdd() {
		return isAdd;
	}

	public void setIsAdd(int isAdd) {
		this.isAdd = isAdd;
	}

	public String getMemberRoleId() {
		return memberRoleId;
	}

	public void setMemberRoleId(String memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
