package TestStu;

import java.util.ArrayList;

public class ClassRoom {
	private String no;
	private double total;
	private ArrayList<Student> banjiList;
	public ClassRoom() {
		banjiList = new ArrayList<Student>();
	}
	public ClassRoom(String no){
		this();
		this.no = no;
	}

	public ClassRoom(String no, ArrayList<Student> banjiList,double total) {
		super();
		this.no = no;
		this.total = total;
		this.banjiList = banjiList;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ArrayList<Student> getStuList() {
		return banjiList;
	}

	public void setStuList(ArrayList<Student> banjiList) {
		this.banjiList = banjiList;
	}


	

	
	
	

}
