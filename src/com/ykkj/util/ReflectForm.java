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
		 *  һ�����쳣
		 */
		try{
			System.out.println("beanclass :"+beanclass);
			Class clazz =Class.forName(beanclass);
			/**
			 * ���Ե� newInstance   ����Ϊ  ���еĶ�д�� Ĭ�Ϲ�����
			 */
			formBean  =(YKKJFormBean)clazz.newInstance();
			
			Field[] filed_ar= clazz.getDeclaredFields();
			
			for(Field f:filed_ar){
				/**
				 * ѯ��ʽ  
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
				System.out.println("���أ�Form  װ��ʧ��");
		}
		
		return formBean;
		
	}
}
