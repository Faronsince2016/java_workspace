package com.free.solarFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import com.free.test.GameUtil;

/*
 设置一个模拟行星绕太阳运动的程序.
行星运动的椭圆方程为：
x=x0+rx*cos(alfa)
y=y0+ry*sin(alfa)
其中
x0、y0为椭圆圆心坐标,
rx为水平半径,ry为垂直半径,
alfa为圆心角.
 */

public class Planet extends Star{

	double longAxis;
	double shortAxis;
	double speed;
	double acspeed;
	double degree = Math.PI/3;
	Star center;

	public Planet(Star center,double longAxis, double shortAxis,  double speed,String imgpath) {
		super(GameUtil.getImage(imgpath));
		this.center = center;
		this.x = center.x+center.width/2 + longAxis;
		this.y = center.y+center.heigh/2+ shortAxis;
		this.longAxis  = longAxis;
		this.shortAxis = shortAxis;
		this.speed 	   = speed;

		
	}
	public void draw(Graphics g){   //draw方法覆盖
		super.draw(g);
		move();
		drawOval(g);

	}
	public void move(){
		this.x = center.x + longAxis*Math.cos(degree);
		this.y = center.y + shortAxis*Math.sin(degree);
		
		degree +=speed;
	}
	
	public void drawOval(Graphics g){
		double ox,oy,ow,oh;
		ow = longAxis*2;
		oh = shortAxis*2;
		ox = center.x+center.width/2-longAxis;
		oy = center.y+center.heigh/2-shortAxis;
		
		
		g.setColor(Color.black);
		g.drawOval((int)ox, (int)oy, (int)ow, (int)oh);
		
		
		
	}
	public Planet(Image img, double x, double y) {
		super(img, x, y);
	}
	public Planet(String imgpath, double x, double y) {
		super(imgpath, x, y);
	}
	
	
   

}
