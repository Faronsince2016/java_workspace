package com.free.copy2;

public class giveAdding {
	public void giveAddingTest(){
		int a  = (int)(Math.random()*100);
		int b  = (int)(Math.random()*100);
		System.out.println("请在5s内计算下面两个数的和："+a+"+"+b);
		String currThread  = Thread.currentThread().getName();
		System.out.println("执行当先程序的线程为："+currThread);
		
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e ){
			System.out.println("sleep被意外中断，异常信息："+e.getMessage());
			return;
		} 
		int  result = a + b;
		System.out.println("a+b的结果为："+result);
	}

}
