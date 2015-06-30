package com.ykkj.demo.vo;

import com.ykkj.annotation.YKKJBean;
import com.ykkj.form.YKKJFormBean;

@YKKJBean(name = "loginForm", clas = LoginForm.class, type = "com.ykkj.demo.control.LoginControl", path = "/login",
	forwardName ={"success","fail"}, forwardValue = { "/user/success.jsp", "/user/fail.jsp" })
public class LoginForm extends YKKJFormBean {
	public LoginForm() {

	}

	private String username = "";
	private String password = "";
	private int age = 0;

	@Override
	public String toString() {
		return "LoginForm [username=" + username + ", password=" + password
				+ ", age=" + age + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
