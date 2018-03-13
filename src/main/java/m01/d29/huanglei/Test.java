/**
 * Project Name:zixi
 * File Name:Test.java
 * Package Name:XML
 * Date:2018年1月29日下午2:04:16
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d29.huanglei;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.sql.rowset.spi.XmlWriter;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.w3c.dom.NodeList;

/**
 * Description:   <br/>
 * Date:     2018年1月29日 下午2:04:16 <br/>
 * @author   huanglei
 * @version
 * @see
 */
public class Test {

    
    public static void main(String[] args) {
      Test tt=new Test();
      tt.aaa();
    //  tt.bbb();//查
     // tt.add();//增
      
     // tt.delete();//刪
     // tt.xiugai();//改
       
    }
    Document document=null;
    public void aaa(){
        SAXReader reader=new SAXReader();
        try {
            document = reader.read(new File("ABC.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void bbb(){
        aaa();
        Element element = document.getRootElement();
        System.out.println(element.getName());
        Iterator<Element>it1=  element.elementIterator();
        while(it1.hasNext()){
            Element ele= it1.next();
            System.out.println(ele.getName()+":"+ele.attributeValue("name"));
            Iterator<Element> iter2= ele.elementIterator();
            while(iter2.hasNext()){
                Element ele2= iter2.next();
                System.out.println(ele2.getName()+":"+ele2.attributeValue("name"));
                Iterator<Element> ite3= ele.elementIterator();
                while(ite3.hasNext()){
                    Element ele3= ite3.next();
                    System.out.println(ele3.getText());
                }
            }
        }
    }
    /*
     **@see增
     *
     * public void add(){
        try {
            Element element=document.getRootElement();
            Element element2=element.addElement("cat");
            element2.addAttribute("name", "猫");
            Element element3=element2.addElement("name");
            element3.addAttribute("name", "毛毛");
            element3.addText("性别：雄");
            saveXML("abc.xml");
        } catch (Exception e) {
            // TODO: handle exception
        }
     }*/
    /**
     * @see刪
     * */
   /* public  void delete(){
        try {
            Element element=document.getRootElement();
            Element element2=element.element("cat");
            Attribute attribute=element2.attribute("name");
            Element element3=element2.element("name");
            element2.remove(attribute);
            element2.remove(element3);
            saveXML("ABC.xml");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }*/
    
    /**
     * @see修改
     * */
   /* public void xiugai(){
        try {
            Element element=document.getRootElement();
            Element element2=element.element("panda");
            Attribute attribute=element2.attribute("name");
            Element element3=element2.element("name");
            Attribute attribut1=element3.attribute("name");
            attribut1.setText("WUH");
            saveXML("abc.xml");
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        
        
    }*/
    
 
   
    
    public void saveXML(String path){
        OutputFormat opf=OutputFormat.createPrettyPrint();
        opf.setEncoding("utf-8");
        XMLWriter xwrit=null;
        try {
            xwrit=new XMLWriter(new FileWriter(path), opf);
            xwrit.write(document);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                xwrit.close();
            } catch (IOException e) {
                
                //  Auto-generated catch block
                e.printStackTrace();
                
            }
        }
        
    }

   
}

