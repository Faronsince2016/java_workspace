package com.free.test;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{

	//加载图片
	Image img = GameUtil.getImage("image/08.gif");
	//加载窗口
	public void launchFrame() {
		setSize(Constant.GAME_HEIGH,Constant.GAME_WIDTH);
		setLocation(200, 200);
		setVisible(true);
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});
	}
	
	
	private double x=200,y=200;
	boolean left = false;
	private double degree = 3.14/3;
	private double speed = 30;
	private double ImageSize = img.getHeight(null);
	
	public void paint(Graphics g) {

        g.drawImage(img,(int)x,(int)y,null);
        
        if(speed> 0){
        	speed-=0.05;
        }
	   //运动
		x +=speed*Math.cos(degree);y += speed*Math.sin(degree);
       //边界判断 
        if(y > Constant.GAME_HEIGH-ImageSize||y < 30){
        	degree = -degree;
        }
        if(x < 0||x > Constant.GAME_WIDTH-ImageSize ){
        	degree = Math.PI-degree;
        }
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
