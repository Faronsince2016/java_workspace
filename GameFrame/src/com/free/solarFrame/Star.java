package com.free.solarFrame;

import java.awt.Graphics;
import java.awt.Image;

import com.free.test.GameUtil;

public class Star {
// 一个星球 有 样子  坐标 运行轨迹
	Image img;
	double x,y;
	double heigh;
	double width;
	
	public void draw(Graphics g){
		g.drawImage(img,(int)x,(int)y,null);
		
		
	}
	public Star(Image img){    // 只传入一个图像的时候调用这个构造函数
		this.img = img;
		this.heigh = img.getHeight(null);
		this.width = img.getWidth(null);
	}
	public Star(Image img ,double x,double y){
		this.x = x;
		this.y = y;
		this.img = img;
		this.heigh = img.getHeight(null);
		this.width = img.getWidth(null);
		
	}
	public Star(String imgpath,double x,double y){
		this(GameUtil.getImage(imgpath) , x, y);  //构造器的互相调用

	}
}
