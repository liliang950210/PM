package com.pm.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

//import jdk.nashorn.internal.ir.RuntimeNode.Request;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pm.service.UserService;
import com.pm.table.User;

@Controller
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	private String username;
	private String password;
	private String errormessage;

	
	public String login() {

		
		User checkExit = userService.findUserByName(username);
		if (checkExit == null) {

			setUsername("");
			setPassword("");
			setErrormessage("帐号不存在");
			return ERROR;
		}

		User user = userService.findUserByUsernameAndPassword(username,password);
		if (user != null) {
			setUsername(username);
			return SUCCESS;
		} else {
			setErrormessage("密码错误");
			setPassword("");
			return ERROR;
		}
		
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

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
}
