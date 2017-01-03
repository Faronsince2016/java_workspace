class MyDate
{
	private int day,month,year;
	public MyDate(int day, int month, int year )
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
}  
class Client
{
	public static void main(String[] args)
    {
	    MyDate md1 = new MyDate(11,11,2016);
		MyDate md2 = new MyDate(11,11,2016);
		System.out.println(md1.toString());
		System.out.println(md2.toString());
	}
}
