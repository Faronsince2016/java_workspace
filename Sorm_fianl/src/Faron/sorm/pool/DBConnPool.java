package Faron.sorm.pool;

import Faron.sorm.core.DBManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 连接池的类
 * @author gaoqi
 *
 */
public class DBConnPool {
	/**
	 * 连接池对象
	 */
	private /*static*/ List<Connection> pool;      //这个List没必要（是没必要）是static的
	
	/**
	 * 里面到底应该放多少个链接 通常定义两个限定  一个最小连接数  一个最大连接数
	 *
	 * 最大连接数
	 * 当连接池中的connnection对象使用完之后  使用者会创建新的connection对象（不是从连接池中取得）
	 * 新的connection对象在使用完之后 通过 DBConnection.close() 将这个链接存放到连接池中
	 * 通过这种途径建立的链接将连接池添加满的时候，即超过了最大连接数  我们就将这个连接真正地关闭。
	 *
	 * 理想方式是这样，但是这里实际没有用到 最大连接池    这里成了一个固定容量的连接池， 我们想要一个可以动态扩容的连接池
	 * 因为当要进行增删改查的时候总是从连接池中取得链接，使用完后又将链接归还给连接池
	 * 所以连接池的数目也就只能在0-10之间变换了
	 * 为了实现上面的构想， 可以在进行增删改查的时候 先去判断目前的连接池是否为空（List.size（）= 0？）
	 * 如果不为空，则使用链接池中对对象， 如果为空，则 使用createConn（）来获得新的链接，
	 * 不管是否使用连接池中现有的对象，在使用结束之后都要将此链接放到连接池中去 close(Connection conn)
	 * 连接池中会增加一个判断pool.size()>=POOL_MAX_SIZE ？ （为节省资源 真正关闭这个链接） ： （将这个链接放到连接池中，以备后续的增删改查再次使用）
	 *
	 */
	private static final int POOL_MAX_SIZE = DBManager.getConf().getPoolMaxSize();
	/**
	 * 最小连接池
	 */
	private static final int POOL_MIN_SIZE = DBManager.getConf().getPoolMinSize();
	
	
	/**
	 * 初始化连接池，使池中的连接数达到最小值
	 */
	public void initPool() {
		if(pool==null){
			pool = new ArrayList<Connection>();
		}
		
		while(pool.size()< Faron.sorm.pool.DBConnPool.POOL_MIN_SIZE){
			pool.add(DBManager.createConn());  //创建POOL_MIN_SIZE个链接对象 并且加入到连接池中
			System.out.println("初始化池，池中连接数："+pool.size());
		}
	}
	
	
	/**
	 * 从连接池中取出一个连接  同步处理 防止两个人同时取一个链接
	 * @return
	 */
	public synchronized Connection getConnection() {
		int last_index = pool.size()-1;
		Connection conn = pool.get(last_index);
		pool.remove(last_index);   //List的remove方法

		return conn;
	}
	
	/**
	 * 将连接放回池中
	 * @param conn
	 */
	public synchronized void close(Connection conn){
		
		if(pool.size()>=POOL_MAX_SIZE){
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			pool.add(conn);
		}
	}
	
	/**
	 * 创建连接池对象的时候直接 init
	 */
	public DBConnPool() {
		initPool();
	}
	
}
