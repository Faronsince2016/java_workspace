package com.free.solarFrame;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{

	//加载窗口
	public void launchFrame() {
        //初始化窗口
		setSize(Constant.GAME_HEIGH,Constant.GAME_WIDTH);
		setLocation(200, 200);
		setVisible(true);  // 窗口默认为不可见的  应设置为ture
		//启动绘图线程 
		new PaintThread().start();
		//关闭窗口的应用
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});
	}
	
	class PaintThread extends Thread{ //这是一个内部类，定义重画窗口的线程类
		public void run() {   //如何启动它？ 
			while(true){
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
				
		}
	}
}
