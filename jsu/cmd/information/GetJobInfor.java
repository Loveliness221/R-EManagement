package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * 获取招聘信息的内容显示至个人用户主界面
 * @author Think
 *
 */
public class GetJobInfor {
      /*
       * 遍历数据库招聘信息表
       * 设置为文本域内容
       */
	public void getInfo(JTextArea textArea) {
		String s="",s1;
		 DataConnectionMysql dbcs=new DataConnectionMysql();//使用定义的连接数据库的类
		  String sql="select * from 招聘信息";//获得查询语句
		 try( Connection conn=dbcs.getConnection();//获取数据库连接
		  PreparedStatement ps=conn.prepareStatement(sql);){//获取处理SQL语句的命令对象
		  ResultSet rs=ps.executeQuery(sql);//获得查询结果集
		while(rs.next())
		{
			
			String position=rs.getString("position");
			String salary=rs.getString("salary");
			String company=rs.getString("company");
			String address=rs.getString("address");
			s1=position+"\n"+salary+"\n"+company+"\n"+address+"\n\n";
			s+=s1;
		}
		
		 }catch (SQLException e) {
			e.printStackTrace();
		}
		textArea.setText(s);
	}
}
