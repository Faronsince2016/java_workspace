package com.faron.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component

public class ExampleBean {
	public ExampleBean(){
		System.out.println("��exampleBean���г�ʼ����");
	}
	public void init() {
		System.out.println("���ǳ�ʼ������");
	}
	
	public void destroy() {
		System.out.println("����������Դ����");
	}
	public void execute() {
		System.out.println("executed....");
	}

}