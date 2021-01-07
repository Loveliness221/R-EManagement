package jsu.cmd.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 连接mysql
 * 定义mysql的数据驱动程序
 * 构造方法连接数据库
 * 返回数据库对象
 * 关闭数据库
 * @author Think
 *
 */
public class DataConnectionMysql {
	// 定义MySQL的数据库驱动程序
			public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver" ;
			// 定义MySQL数据库的连接地址
			public static final String DBURL = "jdbc:mysql://localhost:3306/学生表?useUnicode=true&useSSL=false&serverTimezone=GMT" ;
			// MySQL数据库的连接用户名
			public static final String DBUSER = "root" ;
			// MySQL数据库的连接密码
			public static final String DBPASS = "88211314" ;
			private static Object JOptionPane;
			private Connection conn;
			public DataConnectionMysql(){//构造方法连接数据库
				try {
					Class.forName(DBDRIVER);
					this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
				} catch (Exception e) {e.printStackTrace();}
			}
			public Connection getConnection() {//返回数据库连接对象
				return this.conn;
			}
			public static void main(String[] args) {
				 DataConnectionMysql D=new  DataConnectionMysql();
				 if(D.getConnection()!=null)
				 {
					 //System.out.println("连接成功");
					 ((javax.swing.JOptionPane) JOptionPane).showMessageDialog(null,"success!");
				 }
	}
			public void close() {//关闭数据连接
			    if(this.conn!=null) {
			      try {this.conn.close();} catch (SQLException e) {e.printStackTrace();}
			}
		}
}
