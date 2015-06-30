package com.ykkj.util;

import java.lang.reflect.Field;
import javax.servlet.http.HttpServletRequest;
import com.ykkj.form.YKKJFormBean;

public class ReflectForm {

	public ReflectForm(){
		
	}
	public static YKKJFormBean reflect(String beanclass,HttpServletRequest request){
		YKKJFormBean formBean=null;
		/**
		 *  reflect  
		 *  一定出异常
		 */
		try{
			System.out.println("beanclass :"+beanclass);
			Class clazz =Class.forName(beanclass);
			/**
			 * 可以调 newInstance   是因为  所有的都写了 默认构造器
			 */
			formBean  =(YKKJFormBean)clazz.newInstance();
			
			Field[] filed_ar= clazz.getDeclaredFields();
			
			for(Field f:filed_ar){
				/**
				 * 询问式  
				 */
				f.setAccessible(true);
				
				if(f.getType().equals(int.class)){
					f.setInt(formBean,Integer.parseInt(request.getParameter(f.getName())));
				}else{
					f.set(formBean, request.getParameter(f.getName()));
				}
				
				f.setAccessible(false);
			}
		}catch (Exception e) {
				e.printStackTrace();
				System.out.println("严重：Form  装载失败");
		}
		
		return formBean;
		
	}
}
