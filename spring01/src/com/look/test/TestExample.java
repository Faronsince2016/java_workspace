package com.look.test;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String conf = "applicationContext.xml";
		AbstractApplicationContext ac = 
			new ClassPathXmlApplicationContext(conf);
		
		ExampleBean e1 = ac.getBean("e1",ExampleBean.class);
		System.out.println(e1);
		e1.execute(); 
		ExampleBean e2 = ac.getBean("e1",ExampleBean.class);
		System.out.println(e2);
		
		ac.close();  //�ͷ�spring����     ֻ�����浥���Ķ���ᱻ�ͷ� 

	}

}
 