package com.wqc.sound;


import java.util.Iterator;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class LoadXml {
	public static void main(String[] args) throws DocumentException {
        //1.获取到读取对象
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read("f:\\info.xml");
        Element rootElement = doc.getRootElement();
        getNodes(rootElement);
    }
    static public void getNodes(Element rootElement){
        String name = rootElement.getName();
        System.out.println("节点名称:"+name);
        //获取节点属性
        @SuppressWarnings("unchecked")
		List<Attribute> attributes = rootElement.attributes();
        for (Attribute attribute : attributes) {
            System.out.println("属性名称:"+attribute.getName()+",属性value"+attribute.getValue());
        }
        String value=rootElement.getTextTrim();
        if(!value.equals("")){
            System.out.println("节点value"+value);
        }
        //判断是否有下一个节点
        @SuppressWarnings("unchecked")
		Iterator<Element> elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()) {
            Element next = elementIterator.next();
            getNodes(next);
        }
    }
}
