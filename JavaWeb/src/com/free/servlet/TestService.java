package com.free.servlet;

/**
 * Created by Faron on 2017/3/12.
 */
public class TestService {


    void service(){
        System.out.println("父类的service被调用");
        doGet();   //这里的doGet调用的不是父类的doGet   而是子类的
                   //父类的service是被子类所调用的  所以这里的doGet是在子类的内存中的  要想调用父类的  这里必须使用super.doGet()
    }

    void doGet(){
        System.out.println("父类的doGet被调用!");
    }
}

class ChildrenService extends TestService{
    @Override
    void doGet() {
        System.out.println("子类的doGet被调用");

    }

    @Override
    void service() {
        System.out.println("子类的service被调用！");
        super.service();
    }

}

class  TestMain{
    public  static  void main(String[] args){
        ChildrenService test = new ChildrenService();
        test.service();
    }
}