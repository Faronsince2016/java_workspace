package ParseXMLDemo;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Faron on 2017/1/17.
 */
public class ParseDemo01 {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //从解析工厂中获取解析器
        SAXParser parser = factory.newSAXParser();
        //加载文档（xml） 且注册处理器
        //编写处理器 Handler
        File f = new File("G:\\code\\java_workspace\\Demo\\src\\ParseXMLDemo\\xml.xml");
        PersonHandler handler = new PersonHandler();
        parser.parse(f,handler);


        //处理完后查看下 List中的数据
        List<Person> list = handler.getPersons();

        for (Person p : list){
            if(null != p)
            System.out.println(p.getName()+"---->"+p.getAge());
        }
    }
}
