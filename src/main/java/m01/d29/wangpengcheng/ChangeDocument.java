/**
 * Project Name:shopping
 * File Name:ChangeDocument.java
 * Package Name:com.xml
 * Date:2018年1月29日下午2:59:17
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d29.wangpengcheng;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 需求：改变xml文档中的值，向xml文档中添加元素或者删除元素或者修改元素 <br/>
 * 1.先创建文档对象 <br/>
 * 2.创建元素并向元素中添加属性或者内容 <br/>
 * 3.创建文档的格式流，并定义编码格式 <br/>
 * 4.创建xml输出流，将改变的值写入到文档中 <br/>
 * 5.关闭流<br/>
 * 
 * Description: <br/>
 * Date: 2018年1月29日 下午2:59:17 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class ChangeDocument {
    Document document = null;

    public void getDocument(String path) throws DocumentException {
        File file = new File(path);
        SAXReader saxReader = new SAXReader();
        document = saxReader.read(file);

    }

    public void creatElment() {
        // 获取根节点
        Element element = document.getRootElement();
        // 向根节点中添加子节点
        Element elementChild = element.addElement("Brand");
        // 向节点中添加文字
        elementChild.setText("汪鹏程");

        // 向子节点中添加元素
        Element elementChildel = elementChild.addAttribute("name", "oppo");
        // document.remove(elementChild);
        // 删除某节点，用该节点的父元素删除该元素的子节点
        // element.remove(elementChild);
        // 获取该元素下的name属性，并将其值改为、华为
        Attribute attribute = elementChild.attribute("name");
        attribute.setText("中兴");

    }

    public void WirteDocument(String path) {
        XMLWriter xmlWriter = null;
        // 创建格式xml的流,有格式的写
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        // 将格式流中的编码设成gb2312
        outputFormat.setEncoding("utf-8");
        try {
            // 指明向那个文件中写，并指定编码
            xmlWriter = new XMLWriter(new FileWriter(path), outputFormat);
            // 将当前Document对象中的内容写进去
            xmlWriter.write(document);
            System.out.println("写入成功");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                xmlWriter.close();
            } catch (IOException e) {

                // Auto-generated catch block
                e.printStackTrace();

            }
        }

    }

    public static void main(String[] args) throws DocumentException {
        String string = "NewFile.xml";

        ChangeDocument changeDocument = new ChangeDocument();
        changeDocument.getDocument(string);
        changeDocument.creatElment();
        changeDocument.WirteDocument(string);
    }

}
