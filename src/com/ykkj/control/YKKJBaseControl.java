package com.ykkj.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ykkj.form.YKKJBean;
import com.ykkj.form.YKKJFormBean;
import com.ykkj.util.ReflectForm;

public class YKKJBaseControl extends HttpServlet { 

	/**
	 * 
	 */
	private static final long serialVersionUID = -6017404469226684544L;
	/**
	 * Constructor of the object.
	 */
	public YKKJBaseControl() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
 		
		String path=this.getPath(request.getServletPath());
		Map<String, YKKJBean> map=(Map<String, YKKJBean>) getServletContext().getAttribute("ykkjxml");
		System.out.println("path  "+path);
		YKKJBean ykkjBean=map.get(path);
		/**
		 * 1.  得到 页面的实体
		 */
		String ykkjformbean=ykkjBean.getClas();
	
		//结果的值
		YKKJFormBean ykkjFormBean2=ReflectForm.reflect(ykkjformbean, request);
		
		String  urlclass=ykkjBean.getUrlclass();
		
		YKKJControl control=null;
		String forward="";
		try{
			Class clazz=Class.forName(urlclass);
			control=(YKKJControl)clazz.newInstance();
//			forward=control.excute(request, response, ykkjFormBean2, ykkjBean.getMap());
			forward=control.excute(request, response, ykkjFormBean2);
			forward=ykkjBean.getMap().get(forward);
			
		}catch (Exception e) {
			System.out.println("严重 控制器异常");
			e.printStackTrace();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
		
		
	}

 	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
}
	public void init() throws ServletException {
	}
	private String getPath(String path){
		return path.split("\\.")[0];
	}
}
