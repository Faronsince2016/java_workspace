package com.free.ThreadTest;

public class Player  implements Runnable{
	private Movie m;
	Player(Movie m){
		super();
		this.m = m;
	}
	@Override
	public void run() {
		for(int i = 0; i<=20 ;i++){
			if(0 == i%2){
				m.play("教父1");
			}else {
				m.play("教父2");
			}
		}
	}

}
