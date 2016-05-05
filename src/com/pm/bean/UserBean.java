package com.pm.bean;

/**
 * UserBean对象，负责呈现下拉菜单负责人选择
 * @author JiangLongwei
 * @date 2015年12月8日
 */
public class UserBean {

	private int id;
	private String username;
	private String role;
	private int isSelected;
	private int roleId;
	/**
	 * 标识是否可以作修改
	 */
	private int isChange;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getIsSelected() {
		return isSelected;
	}
	public void setIsSelected(int isSelected) {
		this.isSelected = isSelected;
	}
	public String getRole() {

	
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getIsChange() {
		return isChange;
	}
	public void setIsChange(int isChange) {
		this.isChange = isChange;
	}
	
}
