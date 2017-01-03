package com.free.copy2;

public class TestAddingMain {
	public static void main(String args[])
	{
		Runnable runnable  = new Runnable(){
			public void run(){
				giveAdding addTest = new giveAdding();
				addTest.giveAddingTest();
			}
		};
		Thread thread = new Thread(runnable,"线程：加法测试");
        thread.start();
		System.out.println("主线程结束");
	}

}
