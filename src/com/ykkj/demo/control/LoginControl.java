package com.ykkj.demo.control;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ykkj.control.YKKJControl;
import com.ykkj.demo.vo.LoginForm;
import com.ykkj.form.YKKJFormBean;

public class LoginControl implements YKKJControl {

	public String excute(HttpServletRequest request,
			HttpServletResponse response, YKKJFormBean formBean ) {
		 	LoginForm loginForm=(LoginForm)formBean;
		 	System.out.println(loginForm.toString());
		 	if("kxl".equals(loginForm.getUsername())){
		 		return "success";
		 	}
		return "fail";
	}

}
