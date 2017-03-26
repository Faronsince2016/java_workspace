package com.look.test;

public class ExampleBean {

	
	public  ExampleBean() {
	   System.out.println("在构造器中进行初始化操作。。。。");
		
	}
	
	public void init() {
		System.out.println("xml配置init-method 进行初始化操作。。。。");
	} 
	
	public void mydestroy() {
		System.out.println("单例对象的资源被销毁。。。");
	}
    public void execute() {
		System.out.println("executing……");
	}
}
