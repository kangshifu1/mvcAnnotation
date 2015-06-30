package com.ykkj.control;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ykkj.form.YKKJFormBean;

 

public interface YKKJControl {
	/**
	 * 
	 * 基础 接口  实现该接口方可 使用 该框架 
	 * @param request
	 * @param response
	 * @param formBean
	 * @param urls
	 * @return
	 */
		String excute(HttpServletRequest request ,HttpServletResponse response,YKKJFormBean formBean );
}
