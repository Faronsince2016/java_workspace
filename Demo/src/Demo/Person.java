package Demo;

/**
 * Created by Faron on 2017/1/18.
 */
public class Person {
    private String name;
    public int age;
    public static  int test = 123;

    public Person(){
        System.out.println(age);
        System.out.println(this.name);
    }
    public Person(String names){
        this.name  = names;

    }

    public String getName() {
        return name;
    }

    class  man{
        //static  int j = 2;
        final static  int j = 2;
    }
}
