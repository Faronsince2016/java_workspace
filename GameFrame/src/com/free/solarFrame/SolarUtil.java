package com.free.solarFrame;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/*
 *游戏中常用的工具类
 * @author  Faron
 */

public class SolarUtil {
	
	private SolarUtil(){} //工具类通常会将构造方法私有了,外部就不用调用这个了（多余调用浪费资源），只需要调用static方法就行，
	//对工具类一般是static  
	public static Image getImage(String path) {
		URL u  = SolarUtil.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return img;
	}
}
