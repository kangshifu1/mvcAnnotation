package com.ykkj.Lisenter;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.JDOMException;

import com.ykkj.util.ClassFindUtilByPackageName;
import com.ykkj.util.YKKJBeansUtil;

 
/**
 * 
 * @author Administrator
 *
 */
public class ApplicationXmlLisenter   extends HttpServlet implements ServletContextListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7082817134787342539L;
	 
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("��Ϣ�� ϵͳ�Ѿ�ע��");	
	}
	public void contextInitialized(ServletContextEvent sce) {
		String xmlpath=sce.getServletContext().getInitParameter("ykkjxml");
//		String tomcatpath=sce.getServletContext().getRealPath("\\");
		try {
			
			/*sce.getServletContext().setAttribute("ykkjxml", YKKJBeansUtil.getYKKJBeans(tomcatpath+xmlpath));*/
			sce.getServletContext().setAttribute("ykkjxml", ClassFindUtilByPackageName.getMap(xmlpath));
		}catch (Exception e) {
			System.out.println("ykkjϵͳ�����쳣");
			e.printStackTrace();
			return ;
		} 
		/*catch (JDOMException e) {
			System.out.println("ykkjϵͳ�����쳣");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ykkjϵͳ�����쳣");
			e.printStackTrace();
		}*/
		System.out.println("��Ϣ : ykkjϵͳ�Ѿ�������ɣ���");
	}
	
}
