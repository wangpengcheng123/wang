/**
 * Project Name:shopping
 * File Name:DocumentDmeo.java
 * Package Name:com.xml
 * Date:2018年1月29日下午2:37:16
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d29.wangpengcheng;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 需求：遍历xml文件中的数据 <br/>
 * 1.创建dom4j读取流<br/>
 * 2.根据读取流，读取xml文件，创建一个document对象<br/>
 * 3.根据xml的文件对象，找出xml文件的第一个跟节点<br/>
 * 4.通过跟节点可以获取根节点的下一节的子元素的集合，装入迭代器中<br/>
 * 5.遍历迭代器获取根节点下一节点的子元素，然后在遍历子节点的下一节点，依此类推<br/>
 * Description: <br/>
 * Date: 2018年1月29日 下午2:37:16 <br/>
 * 
 * @author pengchengwang
 * @version
 * @see
 */
public class DocumentDmeo {
    private Document document = null;

    // 将创建文档对象封装起来，便于多次调用
    public void getDocument(String path) throws DocumentException {
        File file = new File(path);
        SAXReader saxReader = new SAXReader();
        document = saxReader.read(file);

    }

    public void readDocument() {
        // 获取节点
        Element element = document.getRootElement();
        // 通过根节点获取下一层子元素的集合
        Iterator<Element> iterator1 = element.elementIterator();
        while (iterator1.hasNext()) {
            // 获取根元素的子元素
            Element elementChild = iterator1.next();
            Attribute attribute = elementChild.attribute("name");
            if (attribute.getText() == "华为") {
                element.remove(elementChild);
            }
            // 获取当前子元素的名称和子元素的属性值
            System.out.println(elementChild.getName() + " " + elementChild.attributeValue("name"));
            // 元素迭代器
            Iterator<Element> iterator2 = elementChild.elementIterator();
            while (iterator2.hasNext()) {
                Element elementChild2 = iterator2.next();
                System.out.println(elementChild2.getName() + " " + elementChild2.attributeValue("name"));

            }

        }

    }

    public static void main(String[] args) throws DocumentException {
        String string = "NewFile.xml";
        DocumentDmeo documentDmeo = new DocumentDmeo();
        documentDmeo.getDocument(string);
        documentDmeo.readDocument();
    }

}
