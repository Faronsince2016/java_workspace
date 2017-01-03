package com.free.solarFrame;

import java.awt.Graphics;
import java.awt.Image;

public class SolarFrame extends MyFrame{
	
	
	
	//加载图片
       Image bg = SolarUtil.getImage("image/bg.jpg");	
	   Star sun = new Star("image/08.gif",Constant.GAME_HEIGH/2,Constant.GAME_WIDTH/2);
	   Planet earth = new Planet(sun,150, 100, 0.1,"image/earth.jpg");
	   
	   public void paint(Graphics g){
		   g.drawImage(bg, 0,0, null);
		   sun.draw(g);
		   earth.draw(g);
	   }	   
	   
	   
		public static void main(String args[]) {
			new SolarFrame().launchFrame();
		}
}
