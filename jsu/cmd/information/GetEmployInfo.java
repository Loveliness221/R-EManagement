package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextArea;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * 遍历数据库求职信息表显示至企业账户界面
 * @author Think
 *
 */
public class GetEmployInfo {
/**
 * 界面用文本域显示数据库中求职信息的内容
 * @param textArea
 */
	public void getInfo(JTextArea textArea) {
		String s="",s1;
		 DataConnectionMysql dbcs=new DataConnectionMysql();//使用定义的连接数据库的类
		  String sql="select * from 求职信息";//获得查询语句
		 try( Connection conn=dbcs.getConnection();//获取数据库连接
		  PreparedStatement ps=conn.prepareStatement(sql);){//获取处理SQL语句的命令对象
		  ResultSet rs=ps.executeQuery(sql);//获得查询结果集
		while(rs.next())
		{
			
			String name=rs.getString("name");
			String sex=rs.getString("sex");
			String age=rs.getString("age");
			String education=rs.getString("education");
			String major=rs.getString("major");
			String number=rs.getString("number");
			String salary=rs.getString("salary");
			String experience=rs.getString("experience");
			s1=name+"  "+sex+"   "+age+"\n"+education+"   "+major+"专业\n电话号码："+number+"\n工作经验："+experience+"\n"+salary+"\n\n";
			s+=s1;
		}
		
		 }catch (SQLException e) {
			e.printStackTrace();
		}
		textArea.setText(s);
	}
}
