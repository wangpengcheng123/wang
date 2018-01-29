/**
 * Project Name:lession
 * File Name:XMLDemo.java
 * Package Name:day20180129
 * Date:2018��1��29������3:34:05
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

pacm01.d29.lilin80129;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * Description:   <br/>
 * Date:     2018��1��29�� ����3:34:05 <br/>
 * @author   11324
 * @version
 * @see
 * 
 *1.����Document����
 *2.ͨ��SAXReader�����read������ȡ��������ָ��λ�õ�xml�ļ��ٸ�ֵ��Document����
 *3.ͨ��Document�����getRootElement()�������ʵ�xml�ļ��ĸ�Ŀ¼
 *4.��ͨ��������add��remove��set��XMLWrite�����������ɾ�Ĳ�
 */
public class XMLDemo {

    public static void main(String[] args) {
        XMLDemo xd = new XMLDemo();
        /*xd.add();
        xd.cha();*/
        xd.cha();
        System.out.println("------------");
        xd.remove();
        System.out.println("------------");
        xd.cha();
        

    }

    Document dmt = null;
    
    //����
    public void jiexi(){
        SAXReader ar = new SAXReader();//����SAXReader����
        try {
            dmt = ar.read(new File("NewFile.xml"));//ͨ��read������ָ��λ�õ�xml�ļ�
        } catch (Exception e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }
    }
    
    //��
    public void cha(){
        jiexi();
        Element et = dmt.getRootElement();//�õ���Ŀ¼���ֵ�ַ
        System.out.println("��Ŀ¼����"+et.getName());
        Iterator<Element> it1 = et.elementIterator(); //������Ŀ¼
        while(it1.hasNext()){
            Element ming1 = it1.next();//�õ��Ӽ�Ŀ¼�ĵ�ַ
            System.out.println(ming1.getName()+" "+ming1.attributeValue("name"));
            Iterator<Element> it2 = ming1.elementIterator();//�����Ӽ�Ŀ¼
            while(it2.hasNext()){
                Element ming2 = it2.next();//�õ����Ӽ�Ŀ¼��ַ
                System.out.println(ming2.getName()+" "+ming2.attributeValue("id"));
            }
        }
        
    }
     
    //���
    public void add(){
        jiexi();
        Element et = dmt.getRootElement();//��Ŀ¼
        Element childet = et.addElement("Man");//�����Ŀ¼
        childet.addAttribute("name", "����");//�����Ŀ¼Ԫ��
        addXtml("NewFile.xml");//д����Ӻ��xml�ļ�
        System.out.println("������");
    }
    
    //ɾ��
    public void remove(){

        jiexi();
        Element et = dmt.getRootElement();//�õ���Ŀ¼���ֵ�ַ
        System.out.println("��Ŀ¼����"+et.getName());
        Iterator<Element> it1 = et.elementIterator(); //������Ŀ¼
        while(it1.hasNext()){
            Element ming1 = it1.next();//�õ��Ӽ�Ŀ¼�ĵ�ַ
           /* System.out.println(ming1.getName()+" "+ming1.attributeValue("name"));*/
            Iterator<Element> it2 = ming1.elementIterator();//�����Ӽ�Ŀ¼
            while(it2.hasNext()){
                Element ming2 = it2.next();//�õ����Ӽ�Ŀ¼��ַ
                /*System.out.println(ming2.getName()+" "+ming2.attributeValue("id"));*/
                ming2.remove(ming2.attribute("id"));
                System.out.println("ɾ��id�ɹ�");
            }
        }
        addXtml("NewFile.xml");   
    }
    
    //��Ԫ����ӵ�Xml�ļ��� 
    public void addXtml(String path){
        OutputFormat opf=OutputFormat.createPrettyPrint();//�õ�xml�ĸ�ʽ
        opf.setEncoding("GBK");//���ø�ʽ����Ҫgb2312
        XMLWriter xwriter = null;
        try {
            xwriter = new XMLWriter(new FileWriter(path),opf);
            xwriter.write(dmt);
        } catch (IOException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }finally{
            try {
                xwriter.close();
            } catch (IOException e) {
                
                //  Auto-generated catch block
                e.printStackTrace();
                
            }
        }
    }
    
}

