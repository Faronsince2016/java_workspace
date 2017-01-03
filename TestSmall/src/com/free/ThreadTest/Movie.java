package com.free.ThreadTest;

/*
 * 生产者消费者问题，一个生产者Player 	 一个消费者Watcher  生产和消费的东西是电影
 * 故创建一个资源类 Movie
 */

public class Movie {
	private String pic;
	
	public  void play(String pic){
		this.pic = pic;
	}
	
	public void watch(){
		System.out.print(pic);
	}

}
