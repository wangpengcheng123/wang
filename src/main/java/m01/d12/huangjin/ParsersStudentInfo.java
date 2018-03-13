/**
 * Project Name:DOMO
 * File Name:ParsersStudentInfo.java
 * Package Name:xmlDomo
 * Date:2018年1月12日下午2:18:03
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d12.huangjin;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Description: <br/>
 * Date: 2018年1月12日 下午2:18:03 <br/>
 * 
 * @author huangjin
 * @version
 * @see
 */
public class ParsersStudentInfo {
    public static void main(String[] args) {
        File file = new File("E:\\eclipse\\DOMO\\src\\xmlDomo\\StudentInfo.xml");
        // 1.创建一个解析器工厂的实例对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;
        // 2.通过解析器工厂对象创建一个解析器
        try {
            // 3.通过解析器解析文件 , 构建DOM树，创建Document对象
            builder = dbf.newDocumentBuilder();
            doc = builder.parse(file);
            // 获取Teacher节点列表信息
            NodeList nl = doc.getElementsByTagName("Teacher");
            NodeList nl2 = doc.getElementsByTagName("Class");
            NodeList nl3 = doc.getElementsByTagName("Student");
            for (int i = 0; i < nl.getLength(); i++) {
                Node stu = nl.item(i);// 获取第i个Teacher元素信息
                Element element = (Element) stu;// 强制转换为Element类型
                String attrvalue = element.getAttribute("name");// 获取属性值
                System.out.println("老师:" + attrvalue);

                Node stu1 = nl2.item(0);// 获取第i个Teacher元素信息
                Element element1 = (Element) stu1;// 强制转换为Element类型
                String attrvalue1 = element1.getAttribute("brade");// 获取属性值
                System.out.println("班级:" + attrvalue1);
                for (int j = 0; j < nl3.getLength(); j++) {

                    NodeList nl4 = doc.getElementsByTagName("name");
                    NodeList nl5 = doc.getElementsByTagName("age");
                    NodeList nl6 = doc.getElementsByTagName("sex");
                    Node stu4 = nl4.item(j);
                    Node stu5 = nl5.item(j);
                    Node stu6 = nl6.item(j);
                    System.out.println("姓名：" + stu4.getFirstChild().getNodeValue());
                    System.out.println("年龄：" + stu5.getFirstChild().getNodeValue());
                    System.out.println("性别：" + stu6.getFirstChild().getNodeValue());
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

    }
}
