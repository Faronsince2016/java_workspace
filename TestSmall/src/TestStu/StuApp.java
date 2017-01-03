package TestStu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StuApp {
	
	public static void main(String[] args) {
		ArrayList<Student> quanbuList = exam();
        
	    Map<String, ClassRoom> map = count(quanbuList);
	    
	    view(map);
	}
	
	
	public static ArrayList<Student> exam() {
      ArrayList<Student> quanbuList = new ArrayList<Student>();
      quanbuList.add(new Student("aa", "01", 81));
      quanbuList.add(new Student("ab", "01", 86));
      quanbuList.add(new Student("axc", "02", 82));
      quanbuList.add(new Student("asdac", "01", 84));
      quanbuList.add(new Student("adf", "03", 82));
      quanbuList.add(new Student("adfa", "01", 85));
      
      return quanbuList;
	}

	public static Map<String, ClassRoom> count(ArrayList<Student> StuList){
		 Map<String, ClassRoom> map = new HashMap<String, ClassRoom>();
		//foreach 遍历学生列表
		  for (Student stu :StuList) {
			  String no = stu.getNo();
			  double score = stu.getScore();
			  //分拣 查看是否存在 该 编号的班级        
		  	//查看班级是否存在
		      //如果不存在，创建班级
			 ClassRoom room = map.get(no);
			  if (null !=room) {
				  room = new ClassRoom(no);
				  map.put(no, room);
			 //如果存在 直接向room中添加学生
			  room.getStuList().add(stu);
			 //计算成绩
			  room.setTotal(room.getTotal()+score);

		}
	
	}
			return map;
	}
	
	public static void view(Map<String, ClassRoom> map) {
		//用key接收keySet中的所有key
		 Set<String> keys =map.keySet(); 
		//获取迭代器对象
		Iterator<String> keysIt = keys.iterator();
		//先判断 
		while(keysIt.hasNext()){
	    //再获取 
			String no = keysIt.next();
			ClassRoom room = map.get(no);
		//计算总分 计算平均分
			double total = room.getTotal();
			double average = total/room.getStuList().size();
		//显示总分和平均分

			System.out.println("班级"+no+"总分"+total+"平均分"+average);
		}
		
	}

}
