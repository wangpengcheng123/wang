/**
 * Project Name:wang
 * File Name:DocumentDemoi.java
 * Package Name:m01.d12.wangpengcheng
 * Date:2018年1月12日下午2:20:18
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d12.wangpengcheng;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Description: <br/>
 * Date: 2018年1月12日 下午2:20:18 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class DocumentDemo {
    private static final Logger LOG = Logger.getLogger(Document.class);

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void show(Document doc, int i) {
        System.out.print("姓名" + doc.getElementsByTagName("name").item(i).getFirstChild().getNodeValue() + "\t");
        System.out.print("年龄" + doc.getElementsByTagName("age").item(i).getFirstChild().getNodeValue() + "\t");
        System.out.print("性别" + doc.getElementsByTagName("gender").item(i).getFirstChild().getNodeValue());
        System.out.print(LINE_SEPARATOR);

    }

    public static void main(String[] args) {
        // 获取DocumentBuilderFactory的实例对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            // 获取DocumentBuilder的实例对象
            db = dbf.newDocumentBuilder();
            // 将给定 内容解析为一个 XML 文档，并且返回一个新的 Document 对象。
            Document doc = db.parse("D:\\wang\\2.xml");

            // 获取标签名为student的节点，并将所有的节点建立一个集合
            NodeList nodeList = doc.getElementsByTagName("student");
            NodeList nodelist1 = doc.getElementsByTagName("class");
            for (int j = 0; j < 2; j++) {
                Element element = (Element) nodelist1.item(j);
                String string = element.getAttribute("id");
                System.out.println(string);

                for (int i = 0; i < nodeList.getLength(); i++) {
                    // 通过item中指定的数据来获取对应的节点，应为文本内容有一个默认的#text标签，所以要获取第一个子元素，然后获取值
                    if (j == 0 && i < 3) {
                        show(doc, i);
                    }
                    if (j == 1 && i >= 3 && i < nodeList.getLength()) {
                        show(doc, i);

                    }
                }
            }
        } catch (SAXException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } catch (ParserConfigurationException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

    }

}
