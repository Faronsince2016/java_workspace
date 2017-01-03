package com.free.fanxing;

import java.util.ArrayList;
/*
 * 泛型的引入  优势 
 */
public class Simple01 {
	public static void main(String[] args) {
//		ArrayList<String> ls = new ArrayList<String>();
//		ls.add("sowhat?");
//		ls.add("how?");
		ArrayList list = new ArrayList();
		list.add("so what? ");
		list.add(123);
		
		//接受数据
		Object obj = list.get(1);
		//强制转型
		Integer num = (Integer)obj;
		//检查类型是否匹配
		if(list.get(1) instanceof Integer){
			num = (Integer)list.get(1);
		}
		
		

		System.out.println(num);
	}

}
