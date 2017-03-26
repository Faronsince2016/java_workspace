package com.look.test;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
	public static void main(String[] args) {
		
	
	String conf = "applicationContext.xml";
	ApplicationContext ac = 
		new ClassPathXmlApplicationContext(conf);
	
	Calendar c1 = ac.getBean("c1",Calendar.class);  //第一个参数是id  第二个参数是要转换成类型
	
	System.out.println(c1);

	}
}


