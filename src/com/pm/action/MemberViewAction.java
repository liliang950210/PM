package com.pm.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pm.bean.UserBean;
import com.pm.service.RelationService;
import com.pm.service.RoleService;
import com.pm.service.UserService;
import com.pm.table.IdRelation;
import com.pm.table.Role;
import com.pm.table.User;
/**
 * 查看人员分工
 * @author JiangLongwei
 * @date 2015年12月8日
 */
@Controller
public class MemberViewAction extends ActionSupport{

	private List<UserBean> userBeans;
	private String projectId;
	/**
	 * roleId 为1时代表项目经理
	 */
	private int roleId;
	
	@Resource
	private RelationService relationService;
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	
	/**
	 * 是否附带添加列 1代表可输入新的，0代表只能读
	 */
	private int isAdd;
	
	/**
	 * 查看人员安排
	 * @return
	 */
	public String viewMember(){
		

		List<IdRelation> relations = relationService.findRelationsByProjectId(getProjectId());
		
		int size = relations.size();
	
		List<UserBean> users = new ArrayList<UserBean>();
		//查找相应的userName 以及角色出来噢
		for(int i=0;i<size;i++){
			
			User user = userService.findUserById(Integer.parseInt(relations.get(i).getUserId()));
			Role role = roleService.findRoleById(Integer.parseInt(relations.get(i).getRoleId()));
			
			if(user==null|| role==null){
				continue;
			}
			UserBean userBean = new UserBean();
			
			userBean.setId(user.getId());
			userBean.setUsername(user.getUsername());
			userBean.setRoleId(role.getRoleId());
			userBean.setRole(role.getRoleName());
			userBean.setIsChange(getRoleId());
			users.add(userBean);
		}
		
		setUserBeans(users);
		setRoleId(getRoleId());
		
		if(getIsAdd()==1){
			setIsAdd(1);
		}
		
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

	public int getIsAdd() {
		return isAdd;
	}

	public void setIsAdd(int isAdd) {
		this.isAdd = isAdd;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
