package TestDateFormat;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestDateFormat{
	public static void main(String args[]){
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd   本月第W周");
		Date d = new Date(10164686582548L);
		String  str1 = df1.format(d);
		System.out.println(str1);
		System.out.println("-----------------------");
		
		DateFormat df2 = new SimpleDateFormat("yyyy.MM.dd");
		String str2 = "2016.11.13";
		try{		
			Date d2 = df2.parse(str2);
			System.out.println(d2);
		}catch (ParseException e ){
			e.printStackTrace();
		}
	}
}