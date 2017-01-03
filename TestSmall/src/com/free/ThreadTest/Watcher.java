package com.free.ThreadTest;

import java.util.Locale.FilteringMode;

import javax.swing.text.html.MinimalHTMLWriter;

public class Watcher implements Runnable{
	private Movie m;

	

	
   public Watcher(Movie m) {
		super();
		this.m = m;
	}



public void run(){
	   m.watch();
	   System.out.println("s");
   }
}
