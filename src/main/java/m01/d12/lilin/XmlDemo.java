/**
 * Project Name:wang
 * File Name:XmlDemo.java
 * Package Name:m01.d10.lilin
 * Date:2018年1月12日下午2:27:59
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d12.lilin;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Description:   <br/>
 * Date:     2018年1月12日 下午2:27:59 <br/>
 * @author   11324
 * @version
 * @see
 */
public class XmlDemo {

    public static void main(String[] args) {
        File f = new File("F:\\javatest\\xx.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse(f);
          /*  NodeList first = d.getElementsByTagName("class1");
            for(int i=0;i<first.getLength();i++){*/
                NodeList second1 = d.getElementsByTagName("student1");
                String str = d.getElementsByTagName("class1").item(0).getAttributes().getNamedItem("id").getNodeValue();
                for(int j=0;j<second1.getLength();j++){
                    System.out.print(str+"："+d.getElementsByTagName("name1").item(j).getFirstChild().getNodeValue());
                    System.out.println("  年龄："+d.getElementsByTagName("age1").item(j).getFirstChild().getNodeValue());
                }                
            /*}*/
                NodeList second2 = d.getElementsByTagName("student2");
                String str1 = d.getElementsByTagName("class2").item(0).getAttributes().getNamedItem("id").getNodeValue();
                for(int j=0;j<second2.getLength();j++){
                    System.out.print(str1+"："+d.getElementsByTagName("name2").item(j).getFirstChild().getNodeValue());
                    System.out.println("  年龄："+d.getElementsByTagName("age2").item(j).getFirstChild().getNodeValue());
                }
                NodeList second3 = d.getElementsByTagName("student3");
                String str2 = d.getElementsByTagName("class3").item(0).getAttributes().getNamedItem("id").getNodeValue();
                for(int j=0;j<second3.getLength();j++){
                    System.out.print(str2+"："+d.getElementsByTagName("name3").item(j).getFirstChild().getNodeValue());
                    System.out.println("  年龄："+d.getElementsByTagName("age3").item(j).getFirstChild().getNodeValue());
                }
        } catch (ParserConfigurationException e) {
            
            
            e.printStackTrace();
            
        } catch (SAXException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        } catch (IOException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }
        

    }

}

