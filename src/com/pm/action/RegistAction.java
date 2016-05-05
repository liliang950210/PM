package com.pm.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pm.service.UserService;
import com.pm.table.User;

@Controller
public class RegistAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	private String username;
	private String password;

	private String errorMsg;
	
	public String regist() {
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);
		
		
		User user = userService.findUserByName(username);
		
		if(user!=null){
			
			setErrorMsg("对不起，你所注册的账户已存在");
		
			return ERROR;
		}
		
		user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userService.saveUser(user);
		
		setErrorMsg("");
		
		return SUCCESS;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}