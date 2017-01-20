package Demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Faron on 2017/1/19.
 */
public class ReflectDemo_3 {

    public static void main(String[] args) throws ClassNotFoundException {
        MyServer server = new MyServer();
        String str = "helllllllo Reflect!";
        Class clazz01 = server.getClass();
        Class clazz02 = String.class;
        Class clazz03 = Class.forName("java.lang.String");
        List list = new ArrayList();
        list.add(clazz01);
        list.add(clazz02);
        list.add(clazz03);
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
//            it.remove(); 移除遍历到的元素
        }
        System.out.println("---------------------------------------------");
//        for (Class clz : list)  错误，要求转型 为什么？
//        for (Object clz : list){   //这里为什么要变成Object类型呢 ？ java提供了List Set Map 3种 ，其中List可以存放任何类型的参数
//                                    //java.io.Serializable 是所有数据类型的父类
//            System.out.println(clz);
//        }
        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));

        }
    }
}
