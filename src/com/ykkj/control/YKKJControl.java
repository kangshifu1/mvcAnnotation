package com.ykkj.control;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ykkj.form.YKKJFormBean;

 

public interface YKKJControl {
	/**
	 * 
	 * ���� �ӿ�  ʵ�ָýӿڷ��� ʹ�� �ÿ�� 
	 * @param request
	 * @param response
	 * @param formBean
	 * @param urls
	 * @return
	 */
		String excute(HttpServletRequest request ,HttpServletResponse response,YKKJFormBean formBean );
}
