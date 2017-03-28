package com.faron.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {

	public static void main(String[] args) {
			String conf = "applicationContext.xml";
			ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
			ExampleBean eBean = ac.getBean("exampleBean",ExampleBean.class);    //默认id = exampleBean   
																				 //首字母转换成了小写   必须这样写
//			eBean.execute();
			
			ac.getBean("exampleBean2", ExampleBean2.class).show();  
			ac.getBean("exam3", ExampleBean3.class).show();         
			
	}

}
