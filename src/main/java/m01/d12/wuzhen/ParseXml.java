/**
 * Project Name:Jenny
 * File Name:ParseXml.java
 * Package Name:homework
 * Date:2018年1月12日下午2:02:44
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d12.wuzhen;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Description: <br/>
 * Date: 2018年1月12日 下午2:02:44 <br/>
 * 
 * @author Wu zhen
 * @version
 * @see
 */
public class ParseXml {
    private final static Logger LOG = Logger.getLogger(ParseXml.class);

    public static void main(String[] args) {
        // 使应用程序能够从XML文档获取生成DOM对象树的解析器；
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();// 不能直接实例化，可以调用方法来获取实例；
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();// 从XML获取一个DOM文档实例;
            File file = new File("D:\\workspace1\\Jenny\\src\\homework\\CreatXml.xml");
            Document d = db.parse(file);// 将指定文件解析成一个XML文档，并返回一个新的DOMdocument对象；
            NodeList classList = d.getElementsByTagName("class");// 返回包含class标签的所有元素的nodelist;
            LOG.info(((Element) classList.item(0)).getAttribute("name"));// 取出class标签的属性值；
            LOG.info(((Element) classList.item(0)).getAttribute("lesson"));
            NodeList studentList = d.getElementsByTagName("student");
            for (int i = 0; i < studentList.getLength(); i++) {
                NodeList nameList = d.getElementsByTagName("name");// 返回包含name标签的所有元素的nodelist;
                NodeList sexList = d.getElementsByTagName("sex");// 返回包含sex标签的所有元素的nodelist;
                NodeList ageList = d.getElementsByTagName("age");// 返回包含age标签的所有元素的nodelist;
                Node node1 = nameList.item(i);// 返回集合中的第i个节点；
                Node node2 = sexList.item(i);
                Node node3 = ageList.item(i);
                LOG.info("==============");
                LOG.info("学生姓名：" + node1.getFirstChild().getNodeValue());
                LOG.info("性别：" + node2.getFirstChild().getNodeValue());
                LOG.info("年龄：" + node3.getFirstChild().getNodeValue());

            }

        } catch (ParserConfigurationException e) {

            e.printStackTrace();

        } catch (SAXException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}
