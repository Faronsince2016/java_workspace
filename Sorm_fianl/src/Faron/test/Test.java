package Faron.test;

import Faron.sorm.core.Query;
import Faron.sorm.core.QueryFactory;
import Faron.vo.EmpVO;

import java.util.List;

/**
 * 客户端调用的测试类
 * @author gaoqi
 *
 */
public class Test {
	public static void main(String[] args) {
		Query q = QueryFactory.createQuery();    //直接通过工厂根据配置文件 返回了匹配的Query对象
		String sql2 = "select e.id,e.empname,salary+bonus 'xinshui',age,d.dname 'deptName',d.address 'deptAddr' from emp e "
			+"join dept d on e.deptId=d.id ";
		List<EmpVO> list2 = q.queryRows(sql2,EmpVO.class, null);
		for(EmpVO e:list2){
			System.out.println(e.getEmpname()+"-"+e.getDeptAddr()+"-"+e.getXinshui());
		}
		
		Query q2 = QueryFactory.createQuery();
		String sql3 = "select e.id,e.empname,salary+bonus 'xinshui',age,d.dname 'deptName',d.address 'deptAddr' from emp e "
			+"join dept d on e.deptId=d.id ";
		List<EmpVO> list3 = q2.queryRows(sql2,EmpVO.class, null);
		for(EmpVO e:list3){
			System.out.println(e.getEmpname()+"-"+e.getDeptAddr()+"-"+e.getXinshui());
		}
	}
}
