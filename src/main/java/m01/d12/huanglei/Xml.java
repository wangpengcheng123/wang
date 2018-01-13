/**
 * Project Name:HomeWork
 * File Name:Xml.java
 * Package Name:xml2018
 * Date:2018年1月12日上午11:46:06
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d12.huanglei;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Description: <br/>
 * Date: 2018年1月12日 上午11:46:06 <br/>
 * 
 * @author huanglei
 * @version
 * @see
 */
public class Xml {

    public static void main(String[] args) throws ParserConfigurationException {
        long lasting = System.currentTimeMillis();
        try {
            File f = new File("D:\\eclipse\\eclipse1\\HomeWork\\src\\xml2018\\NewFile.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // 通过工厂类的静态方法，创建一个新的 DocumentBuilder 工厂实例。
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 文档建造者工厂，生产一个新的文档建造者
            org.w3c.dom.Document doc = builder.parse(f);
            // 解析文档对象
            NodeList nodeList1 = doc.getElementsByTagName("name");
            // 标签读取元素存入nodeList
            NodeList nodeList2 = doc.getElementsByTagName("class");
            for (int j = 0; j < nodeList2.getLength(); j++) {
                Element e = (Element) nodeList2.item(j);
                // 通过index读取集合，获得元素
                String e1 = e.getAttribute("id");
                System.out.println(e1);

                for (int i = 0; i < nodeList1.getLength(); i++) {
                    if (i < 6 && j == 0) {
                        Node node = nodeList1.item(i);
                        // 获取文档节点
                        Node node1 = node.getFirstChild();
                        // 获取文档子节点
                        String string2 = node1.getNodeValue();
                        System.out.println(string2);
                    }
                    if (i >= 6 && i < nodeList1.getLength() && j == 1) {
                        Node node = nodeList1.item(i);
                        Node node1 = node.getFirstChild();
                        String string2 = node1.getNodeValue();
                        System.out.println(string2);
                    }
                }

            }

        } catch (SAXException | IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

    }

}
