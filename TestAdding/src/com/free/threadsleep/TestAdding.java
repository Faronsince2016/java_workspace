package com.free.threadsleep;
public class TestAdding{
	public void GiveAddingTest(){
		int a = (int) (Math.random()*100);
		int b = (int) (Math.random()*100);
		System.out.println("Plese compute two numbers's addition in 5s:"+a+"+"+b);
		
		String currThread = Thread.currentThread().getName();
		System.out.println("当前线程的名字:"+currThread);
		
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			System.out.println("出错了，错误的信息为："+e.getMessage());
			return;
		}
		int result = a + b;
		System.out.println("a+b的结果为："+result+"   你算对了吗？ ");
	}
}