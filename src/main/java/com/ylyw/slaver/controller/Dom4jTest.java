package com.ylyw.slaver.controller;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @program: my-springboot
 * @description: dom4j测试
 * @author: Xue0601
 * @create: 2018-08-22 13:36
 **/
public class Dom4jTest {

    public static void main(String[] args) throws DocumentException{

        SAXReader reader = new SAXReader();

        Document document = reader.read("src/main/java/com/dom4j/userInfo.xml");

        Element root = document.getRootElement();

        List<Element> list = root.elements();

        for (Element element : list) {
            //获取属性值
            String no = element.attributeValue("no");
            String name = element.element("name").getText();
            String age = element.element("age").getText();
            System.out.println(no+name+age);
        }

    }


}
