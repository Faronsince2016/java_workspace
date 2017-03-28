package com.faron.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {

	public static void main(String[] args) {
			String conf = "applicationContext.xml";
			ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
			ExampleBean eBean = ac.getBean("exampleBean",ExampleBean.class);
			eBean.execute();
	}

}
