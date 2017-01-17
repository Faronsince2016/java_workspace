package ParseXMLDemo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faron on 2017/1/17.
 */
public class PersonHandler extends DefaultHandler{
    private  Person person;
    private List<Person> persons;
    private String tag;
    @Override
    public void startDocument() throws SAXException {
        System.out.println("读取文档开始");
        persons = new ArrayList<Person>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("读取元素开始"+qName);
        if(null != qName && !qName.equals("")){
            tag = qName;
        }
        if(null != tag && tag.equals("person")){
            person = new Person();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //System.out.println(new String(ch,start,length));
        String str = new String(ch,start,length);
        if(null != tag && tag.equals("name")){
            person.setName(str);
        }else if (null != tag && tag.equals("age")){
            Integer age = Integer.valueOf(str);
            person.setAge(age);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("读取元素结束"+qName);
        if(null != qName && qName.equals("person")){
            this.persons.add(person);    //这里要用this来指代当前正在进行操作的对象 不加可以，加了清楚
        }
        tag = null;


    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("读取文档结束");
    }

    public List<Person> getPersons() {
        return persons;
    }
}
