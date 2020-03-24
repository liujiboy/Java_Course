package edu.cqu.v3;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ApplicationContex {
	private Map<String, Object> map = new HashMap<>();

	public ApplicationContex(String configFileName) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document d = builder.parse(this.getClass().getResourceAsStream(configFileName));
			//获取所有bean标签
			NodeList beans = d.getElementsByTagName("bean");
			for(int i=0;i<beans.getLength();i++)
			{
				Node bean=beans.item(i);
				//获取bean:id
				String id=bean.getAttributes().getNamedItem("id").getNodeValue();
				//获取bean:class
				String className=bean.getAttributes().getNamedItem("class").getNodeValue();
				//创建bean
				Object obj=Class.forName(className).newInstance();
				//保存bean
				map.put(id, obj);
				for(int j=0;j<bean.getChildNodes().getLength();j++)
				{
					//获取property
					if(bean.getChildNodes().item(j).getNodeName().equals("property"))
					{
						Node property=bean.getChildNodes().item(j);
						//获取property:name
						String propertyName=property.getAttributes().getNamedItem("name").getNodeValue();
						//获取property:ref-bean
						String refBeanName=property.getAttributes().getNamedItem("ref-bean").getNodeValue();
						//设置bean的property
						Field propertyField=obj.getClass().getDeclaredField(propertyName);
						propertyField.setAccessible(true);
						propertyField.set(obj, map.get(refBeanName));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object getBean(String beanName) {
		return map.get(beanName);
	}


}
