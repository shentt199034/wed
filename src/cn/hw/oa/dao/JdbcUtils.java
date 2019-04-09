package cn.hw.oa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 此类是数据库连接的工具类,主要用来连接数据库，和关闭连接
public class JdbcUtils {

	// 静态块,仅仅执行一次
	static {
		// 加载数据库的使用说明书(数据库驱动)
		// forName系统提供的静态方法,类直接调用。它的功能是根据类全名来加载相关资源
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("------------------");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// 此方法用来实现数据库的连接,并且返回连接对象
	public static Connection getConnection() {
		//
		// 采用Java提供的工具类来连接数据库
		try {
			System.out.println("加载成功");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public static void close (Connection conn) {
		//
		// 采用Java提供的工具类来连接数据库
		try {
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 编写一个main方法测试数据库的连接
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

