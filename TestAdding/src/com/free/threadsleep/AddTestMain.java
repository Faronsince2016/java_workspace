package com.free.threadsleep;
public class AddTestMain{
	public static void main(String args[]){
		Runnable runnable = new Runnable(){
			public void run(){
				TestAdding adding = new TestAdding();
				adding.GiveAddingTest();
				
			}
		};
		Thread thread = new Thread(runnable,"加法测试线程");
		thread.start();
		System.out.println("主线程结束");
	}
}