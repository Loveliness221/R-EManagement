package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * 将用户填写的招聘信息更新至数据库招聘信息表
 * @author Think
 *
 */
public class PostRecruitment {
	 public void addCom(JTextField textFieldZw,JTextField textFieldXz,JTextField textFieldQym,JTextField textFieldQydz)
	  {
		  DataConnectionMysql dbcs=new DataConnectionMysql();//使用定义的连接数据库的类
		  //如果存在旧招聘则更改，不存在则插入
		  	String sql="replace into 招聘信息('position','salary','company','address') values(?,?,?,?,)";//使用占位符定义插入语句
		  	try(Connection conn=dbcs.getConnection();//获取数据库接
		  		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
		  		String position=textFieldZw.getText();
		  		String salary=textFieldXz.getText();
		  		String company=textFieldQym.getText();
		  		String address=textFieldQydz.getText();
		  		pstmt.setString(1, position);//定义第1个占位符的内容
	    		pstmt.setString(2, salary);//定义第2个占位符的内容
	    		pstmt.setString(3, company);//定义第2个占位符的内容
	    		pstmt.setString(4, address);//定义第2个占位符的内容
	    		pstmt.executeUpdate();//执行一条插入语句
		  		
		  	} catch (SQLException e) {
				e.printStackTrace();
			}
}
}
