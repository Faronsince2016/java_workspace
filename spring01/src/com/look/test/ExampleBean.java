package com.look.test;

public class ExampleBean {

	
	public  ExampleBean() {
	   System.out.println("�ڹ������н��г�ʼ��������������");
		
	}
	
	public void init() {
		System.out.println("xml����init-method ���г�ʼ��������������");
	} 
	
	public void mydestroy() {
		System.out.println("�����������Դ�����١�����");
	}
    public void execute() {
		System.out.println("executing����");
	}
}
