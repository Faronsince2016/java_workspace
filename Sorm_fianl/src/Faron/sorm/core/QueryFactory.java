package Faron.sorm.core;

/**
 * 创建Query对象的工厂类
 * 需要写改 Query的时候直接看修改工厂就好了   客户端不需要变动
 * @author lw
 *
 */
public class QueryFactory {
	
	private static Query prototypeObj;  //原型对象   用来克隆的   这样加载的时候我们执行一次对象的赋值就可以了	   Query需要实现cloneable接口 才能使用clone


	static {   //全部设计成static的方式不好  为什么不好？？？

		try {
			Class c = Class.forName(DBManager.getConf().getQueryClass());  ////加载指定的query类   配置文件配置了谁，我就获取了谁
			prototypeObj = (Query) c.newInstance();   //对原型对象进行赋值
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
		//加载po包下面所有的类，便于重用，提高效率！
		TableContext.loadPOTables();
		
		
	}
	
	private QueryFactory(){  //私有构造器
	}
	
	
	public static Query createQuery(){
		//return (Query)c.newInstance()     作为一个对外提供服务的产品，使用 通过反射  newInstance（）这种方法可能会降低我们的一些效率    改进如下
		//或者如下这样  转换成对象之后  再cast返回
		try {
			return (Query) prototypeObj.clone();    //Query对象获取的时候我们采用克隆模式来获取  能更快一些    查阅克隆模式和直接反射得到的效率区别？
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
