package jsu.cmd.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * ����mysql
 * ����mysql��������������
 * ���췽���������ݿ�
 * �������ݿ����
 * �ر����ݿ�
 * @author Think
 *
 */
public class DataConnectionMysql {
	// ����MySQL�����ݿ���������
			public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver" ;
			// ����MySQL���ݿ�����ӵ�ַ
			public static final String DBURL = "jdbc:mysql://localhost:3306/ѧ����?useUnicode=true&useSSL=false&serverTimezone=GMT" ;
			// MySQL���ݿ�������û���
			public static final String DBUSER = "root" ;
			// MySQL���ݿ����������
			public static final String DBPASS = "88211314" ;
			private static Object JOptionPane;
			private Connection conn;
			public DataConnectionMysql(){//���췽���������ݿ�
				try {
					Class.forName(DBDRIVER);
					this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
				} catch (Exception e) {e.printStackTrace();}
			}
			public Connection getConnection() {//�������ݿ����Ӷ���
				return this.conn;
			}
			public static void main(String[] args) {
				 DataConnectionMysql D=new  DataConnectionMysql();
				 if(D.getConnection()!=null)
				 {
					 //System.out.println("���ӳɹ�");
					 ((javax.swing.JOptionPane) JOptionPane).showMessageDialog(null,"success!");
				 }
	}
			public void close() {//�ر���������
			    if(this.conn!=null) {
			      try {this.conn.close();} catch (SQLException e) {e.printStackTrace();}
			}
		}
}
