package com.ykkj.form;

import java.util.Map;

/**
 * xml -->bean
 * @author Administrator
 *
 */
public class YKKJBean implements Comparable{
	/**
	 * ����� ykkj Bean������
	 *  
	 */
	private String name ="";
	/**
	 * ��Ӧ ykkjbean �����λ��
	 * ������
	 */
	private String clas="";
	/**
	 * ��Ӧ�� ��ͼ�� ������  λ��   
	 * ������
	 */
	private String urlclass="";
	/**
	 * ��Ӧ��  ��ͼ�㴦�����  ��Ӧ ����·��
	 */
	private  String  urlpath="";
	/**
	 * �������� ����ֵ���� ��������� ·����ת
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
