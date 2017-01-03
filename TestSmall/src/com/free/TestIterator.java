package com.free;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PrinterLocation;
public class TestIterator {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("i love ");
		list.add("java");
        String string = list.get(0)+list.get(1);
	   System.out.println(string);
	}
}
