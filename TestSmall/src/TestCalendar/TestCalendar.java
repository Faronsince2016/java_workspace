package TestCalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {
	public static void main(String args[]){
		Calendar c = new GregorianCalendar();
		c.set(2014, 11, 13, 11, 53, 30);
		System.out.println(c.toString());
		System.out.println("----------------");
		
		
		//new Date（）；默认获取当前系统时间
		c.setTime(new Date());
		System.out.println(c.toString());
		Date d = new Date (c.getTimeInMillis());   //c.getTimeInMillis()  Calendar的方法
		System.out.println(d);
		
		//测试日期计算
		c.add(Calendar.MONTH, 2);
		Date d2 = new Date (c.getTimeInMillis());   //c.getTimeInMillis()  Calendar的方法
		System.out.println(d2);
	}
}
