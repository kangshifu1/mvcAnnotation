package com.ykkj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ���������ʵ��ע��� ��Ҫ���� 
 * ���н�����һЩ xml�е�Ԫ�� ���� listener�н�������
 * �������Ժ���Ȼ��  map<String,YKKJBean>  �Ž�application�ռ���
 * @author ykkj
 *
 */
@Retention(value = RetentionPolicy.RUNTIME)
/*@Target(value=ElementType.METHOD)*/
public @interface YKKJBean {
	/**
	 * bean����
	 * ykkj
	 * YKKJBean.java
	 */
	String name();
	/**
	 * bean �������·��
	 * ykkj
	 * YKKJBean.java
	 */
	Class<?> clas();
	/**
	 * ����� ��Ӧ�Ĵ��������·��
	 * ykkj
	 * YKKJBean.java
	 */
	String type();
	/**
	 * 
	 * ��Ӧ��url ����·��
	 * ykkj
	 * YKKJBean.java
	 */
	String path();
	/**
	 *  ��Ӧ�ķ���ֵ�� ����
	 * ykkj---->map
	 * YKKJBean.java
	 */
	String[]  forwardName();
	/**
	 *  ��Ӧ����ֵ�� ��ת·��
	 * ykkj ---->map
	 * YKKJBean.java
	 */
	String[] forwardValue();
	 
}
