package com.ykkj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这个是用于实现注解的 重要方法 
 * 其中将定义一些 xml中的元素 将在 listener中解析出来
 * 解析出以后仍然是  map<String,YKKJBean>  放进application空间中
 * @author ykkj
 *
 */
@Retention(value = RetentionPolicy.RUNTIME)
/*@Target(value=ElementType.METHOD)*/
public @interface YKKJBean {
	/**
	 * bean名称
	 * ykkj
	 * YKKJBean.java
	 */
	String name();
	/**
	 * bean 的类解析路径
	 * ykkj
	 * YKKJBean.java
	 */
	Class<?> clas();
	/**
	 * 这个是 对应的处理类的类路径
	 * ykkj
	 * YKKJBean.java
	 */
	String type();
	/**
	 * 
	 * 对应的url 访问路径
	 * ykkj
	 * YKKJBean.java
	 */
	String path();
	/**
	 *  对应的返回值的 内容
	 * ykkj---->map
	 * YKKJBean.java
	 */
	String[]  forwardName();
	/**
	 *  对应返回值的 跳转路径
	 * ykkj ---->map
	 * YKKJBean.java
	 */
	String[] forwardValue();
	 
}
