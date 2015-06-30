package com.ykkj.form;

import java.util.Map;

/**
 * xml -->bean
 * @author Administrator
 *
 */
public class YKKJBean implements Comparable{
	/**
	 * 这个是 ykkj Bean的名称
	 *  
	 */
	private String name ="";
	/**
	 * 对应 ykkjbean 的类的位置
	 * 带包名
	 */
	private String clas="";
	/**
	 * 对应的 视图层 处理类  位置   
	 * 带包名
	 */
	private String urlclass="";
	/**
	 * 对应的  视图层处理类的  对应 访问路径
	 */
	private  String  urlpath="";
	/**
	 * 处理结果的 返回值分析 及结果反馈 路径跳转
	 */
	private Map<String,String>  map=null;
	public boolean equals(Object e){
		return false;
	}
	public int compareTo(Object o) {
		return 0;
	}
	@Override
	public String toString() {
		return "YKKJBean [name=" + name + ", clas=" + clas + ", urlclass="
				+ urlclass + ", urlpath=" + urlpath + ", map=" + map + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public String getUrlclass() {
		return urlclass;
	}
	public void setUrlclass(String urlclass) {
		this.urlclass = urlclass;
	}
	public String getUrlpath() {
		return urlpath;
	}
	public void setUrlpath(String urlpath) {
		this.urlpath = urlpath;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public YKKJBean() {
		super();
	}
	

	
	
	
	
}
