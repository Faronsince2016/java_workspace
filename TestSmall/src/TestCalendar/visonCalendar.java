package TestCalendar;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class visonCalendar {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
	    String temp = scanner.nextLine();
	    scanner.close();
		Calendar calendar = new GregorianCalendar();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date date = df.parse(temp);
		    calendar.setTime(date);
		    int day = calendar.get(Calendar.DATE);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			int FirstDay = calendar.get(Calendar.DAY_OF_WEEK);
			int maxDate   = calendar.getActualMaximum(Calendar.DATE);
			System.out.println(FirstDay);
			
			System.out.println("��\tһ\t��\t��\t��\t��\t��");
			for(int i = 1; i <= maxDate; i++ ){
				if (i == day){
					System.out.print("*");
				}
				while((FirstDay-1)>0){   //������Ҫ��ӡ�ĸ�ʽ������1�Ŵӵ�FirstDay�쿪ʼ������ǰ����Ҫ��FirstDay-1����" \t"  
					System.out.print(" \t");
					FirstDay--;
				}
		    
			System.out.print(i+"\t");
			int w = calendar.get(Calendar.DAY_OF_WEEK);
			if(w == Calendar.SATURDAY){  //ÿ����������
				System.out.print("\n");
			}
			calendar.add(Calendar.DATE, 1);  //��1�ſ�ʼ��ӡ��ÿ�δ�ӡ�����ڼ�1��������if�ж���Ч
				
		}
			} catch (ParseException e) {
			e.printStackTrace();
		}
			
	}

}
