package com.cheky.springboot.demo.xml;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * @author cheky
 * @date 2020-12-21
 */
public class Dom4jTest {

    private final String xmlFilePath = "demo\\sample.xml";

    @Test
    public void testLoadXmlFromFilePath() throws DocumentException {
        Document document = null;
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(new File(xmlFilePath)); // 读取XML文件,获得document对象
        assert document != null;
    }

    @Test
    public void testLoadXmlFromText() throws DocumentException {
        String text = "<members></members>";
        Document document = DocumentHelper.parseText(text);
        assert document != null;
    }

    @Test
    public void testCreateDocument(){
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("members");// 创建根节点
    }

    @Test
    public void testWriteXml() throws DocumentException, IOException {
        Document dom = null;
        SAXReader saxReader = new SAXReader();
        dom = saxReader.read(new File(xmlFilePath));

        Element root = dom.getRootElement(); //获取根节点

        //添加新节点
        Element menuElement = root.addElement("menu");
        Element engNameElement = menuElement.addElement("engName");
        engNameElement.setText("catNameEn");
        engNameElement.addComment("This is a test for dom4j ");// 加入一行注释
        engNameElement.addAttribute("show", "yes");// 添加属性内容
        engNameElement.addCDATA("demo CDATA"); //添加CDATA
        Element chiNameElement = menuElement.addElement("chiName");
        chiNameElement.setText("catName");

        //修改节点属性
        List list = dom.selectNodes("/root/users/user/@name");// 用xpath查找节点user的属性
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Attribute attribute = (Attribute) iter.next();
            if (attribute.getValue().equals("cheky"))
                attribute.setValue("Cheky Yao");
        }

        //删除节点
        List list3 = dom.selectNodes("/root/users");// 用xpath查找节点user的内容
        Iterator iter3 = list3.iterator();
        while (iter3.hasNext()) {
            var usersElement = (Element) iter3.next();
            Iterator iterator = usersElement.elementIterator("user");
            while (iterator.hasNext()){
                Element userElement = (Element) iterator.next();
                if (userElement.getText().equals("will be deleted")) {
                    usersElement.remove(userElement);
                }
            }
        }

        //修改节点Text
        List list2 = dom.selectNodes("/root/users/user");// 用xpath查找节点user的内容
        Iterator iter2 = list2.iterator();
        while (iter2.hasNext()) {
            Element element = (Element) iter2.next();
            element.setText("demo text");// 设置相应的内容
        }

        //输出Xml
        XMLWriter writer = new XMLWriter(new OutputStreamWriter(
                new FileOutputStream("target\\sample.xml"), "UTF-8"));
        writer.write(dom);
        writer.close();
    }
}
