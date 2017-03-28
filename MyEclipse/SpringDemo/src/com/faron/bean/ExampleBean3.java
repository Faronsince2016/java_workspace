package com.faron.bean;

import org.springframework.stereotype.Component;

@Component("exam3")      //指定ID后就只能通过指定的ID访问
public class ExampleBean3 {
		public void show() {
			System.out.println("--------------------show-ExampleBean3------");
		}
}