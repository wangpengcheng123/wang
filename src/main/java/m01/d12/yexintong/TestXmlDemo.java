/**
 * Project Name:JavaPractice1
 * File Name:TestXmlDemo.java
 * Package Name:m01.d12.yexintong
 * Date:2018年1月12日下午2:02:23
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d12.yexintong;

import java.io.File;
import java.io.IOException;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Description: <br/>
 * Date: 2018年1月12日 下午2:02:23 <br/>
 * 
 * @author YeXinTong
 * @version
 * @see
 */
public class TestXmlDemo {

    public static void main(String[] args) {
        long lathing = System.currentTimeMillis();
        try {
            File file = new File("E:\\eclipse\\JavaPractice1\\src\\m01\\d12\\yexintong\\XmlDemo.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            NodeList nodeList1 = document.getElementsByTagName("class");
            for (int k = 1; k < nodeList1.getLength() + 1; k++) {
                NodeList nodeList2 = document.getElementsByTagName("squad");
                for (int i = 1; i < nodeList2.getLength() + 1; i++) { 
                    org.w3c.dom.Element element=(org.w3c.dom.Element)nodeList2.item(i-1);
                    String string=element.getAttribute("id");
                    System.out.println(string); 
                    String string1 = "";
                    string1 = "name" + i;
                    NodeList nodeList3 = document.getElementsByTagName(string1);
                    for (int j = 0; j < nodeList3.getLength(); j++) {
                        String str2 = nodeList3.item(j).getFirstChild().getNodeValue();
                        System.out.println("第" + i + "组的人有" + str2);
                    }
                }
            }
        } catch (ParserConfigurationException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } catch (SAXException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        System.out.println("运行所耗时间为" + (System.currentTimeMillis() - lathing) + "毫秒");

    }

}
