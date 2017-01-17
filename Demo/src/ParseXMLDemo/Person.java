package ParseXMLDemo;

/**
 * Created by Faron on 2017/1/17.
 */
public class Person {
    private String name;
    private int age;
    public Person(){
    }

    public Person(String name ,int age){
        super();
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
