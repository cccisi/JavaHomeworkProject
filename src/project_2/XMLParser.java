package project_2;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * @Auther: 信工所 陈朝晖 201728018627076
 * @Date: 4/27/2018 20:38
 * @Description: 利用DOM4J包对作业2要求的XML文件解析
 */
public class XMLParser {

    public static void main(String[] args) {

        Book mbook;
//            File directory = new File("");//设定为当前文件夹
//            String absolutePath = new String();
//            try{
//                absolutePath = directory.getAbsolutePath();//获取绝对路径
//            }catch(Exception e){}
//            File mFile = new File(absolutePath + File.separator+"src" +File.separator + XMLParser.class.getPackage().getName()+File.separator+"books.xml");

        File mFile = new File("src" + File.separator + XMLParser.class.getPackage().getName() + File.separator + "books.xml");
        System.out.println(mFile.length());
        //创建books的解析器
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(mFile);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = null;
        if (document != null) {
            root = document.getRootElement();
        }
        List<Element> list = null;
        if (root != null) {
            list = root.elements();
        }

        for (Element e : list) {
            //获取书的节点属性值
            String id = e.attributeValue("id");
            String title = e.element("title").getText();
            String auther = e.element("author").getText();
            String price = e.element("price").getText();

            mbook = new Book(id, title, auther, price);
            System.out.println(mbook.getDetail());
        }

    }
}

class Book {
    public String id, title, author, price;

    public Book(String id, String title, String author, String price) {
        this.id = id;
        this.author = author;
        this.price = price;
        this.title = title;
    }

    public String getDetail() {
        return "编号" + id + "书是" + author + "创作的" + title + ",定价为" + price;
    }
}