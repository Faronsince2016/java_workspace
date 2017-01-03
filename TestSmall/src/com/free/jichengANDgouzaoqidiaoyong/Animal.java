package com.free.jichengANDgouzaoqidiaoyong;

public class Animal {
	String eye;
	
	public void run(){
		System.out.println("run!");
	}
	public void eat(){
		System.out.println("eat!");
	}
	public void sleep(){
		System.out.println("zzz!");
	}
	
	public Animal(){
		super();
		System.out.println("new a animal!");
	}
} 

class Bird extends Animal{
	public void run(){         //方法的重载
		System.out.println("哈哈，我重写了父类的方法，我就是不run！");
	}
	public void eggBirth(){
		System.out.println("我在父类的基础上拓展了一个方法，卵生");
	}
	
	public Bird(){
		super();   //调用父类，也就是调用Animal类的构造方法
		System.out.println("已完成调用Animal类的构造方法");
		
	}
}
