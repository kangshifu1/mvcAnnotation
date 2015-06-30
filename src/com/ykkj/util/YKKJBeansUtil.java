package com.ykkj.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.ykkj.form.YKKJBean;

public class YKKJBeansUtil {
	public  static  Map<String,YKKJBean> getYKKJBeans(String xmlpath) throws JDOMException, IOException{
		/**
		 * 加载 xml文件
		 */
		SAXBuilder builder=new SAXBuilder();
		Document document =builder.build(xmlpath);
		Element root =document.getRootElement();
		/**
		 * 获得 root
		 */
		Map<String ,YKKJBean> map=new HashMap<String, YKKJBean>();
		/**
		 * 循环得出  beanmap
		 */
		Element bean=root.getChild("ykkj-beans");
		
		List<Element> beans=bean.getChildren();
		Map<String ,String > beanmap=new HashMap<String, String>();
		
		for(Element e:beans){
			beanmap.put(e.getAttributeValue("name"),e.getAttributeValue("class"));
		}
		/**
		 * 得到  urlmapping
		 */
		Element ykkjurl=root.getChild("url-mapping");
		List<Element>  ykkjurls=ykkjurl.getChildren();
		/**
		 * 放入 map
		 * 
		 */
		for(Element e:ykkjurls){
			YKKJBean bean1=new YKKJBean();
			  bean1.setName(e.getAttributeValue("name"));
			  bean1.setUrlclass(e.getAttributeValue("type"));
			  bean1.setUrlpath(e.getAttributeValue("path"));
			  
			  bean1.setClas(beanmap.get(bean1.getName()));
			  
			  
			  List<Element> elements=e.getChildren();
			  Map<String,String> forwards=new HashMap<String, String>();
			  	for(Element element:elements){
				   forwards.put(element.getAttributeValue("name"),element.getAttributeValue("value"));
			  }
			  bean1.setMap(forwards);
			  
			  
			  map.put(bean1.getUrlpath(), bean1);
		}
		System.out.println(map);
		return map;
	}
	
}
