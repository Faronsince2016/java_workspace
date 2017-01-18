package Demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Faron on 2017/1/18.
 * 反射的性能优化
 */
public class ReflectTest {

    //普通方法调用
    public static void test01(){
        Person person1  = new Person();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <1000000000L ; i++) {
            person1.getName();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("普通方法调用10亿次共用时："+(endTime-startTime)+"ms");
    }
    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person1  = new Person();
        Class<Person> clazz = (Class<Person>) person1.getClass();
        Method m = clazz.getDeclaredMethod("getName",null);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <1000000000L ; i++) {
            m.invoke(person1,null);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("反射有安全检查方法调用10亿次共用时："+(endTime-startTime)+"ms");

    }

    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person1  = new Person();
        Class<Person> clazz = (Class<Person>) person1.getClass();
        Method m = clazz.getDeclaredMethod("getName",null);
        m.setAccessible(true);  //跳过安全检查
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <1000000000L ; i++) {
            m.invoke(person1,null);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("反射、无安全检查方法调用10亿次共用时："+(endTime-startTime)+"ms");

    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();


    }


}

