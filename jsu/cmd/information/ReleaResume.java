package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * 将用户填写简历更新至数据库
 * @author Think
 *
 */
public class ReleaResume {
	String s;
	/**
	 * 监听判断用户性别
	 */
  public void CheckMan()
  {
	  s="男";
  }
  public void CheckWoman() {
	  s="女";
  }
  public void addPer(JTextField textFieldXm,JTextField textFieldNl,JTextField textFieldMajor,JTextField textFieldEducation,JTextField textFieldNumber,JTextField textFieldSalary,JTextField textFieldExperience)
  {
	  DataConnectionMysql dbcs=new DataConnectionMysql();//使用定义的连接数据库的类
	  //如果存在旧简历则更改，不存在则插入
	  	String sql="replace into 求职信息('name','sex','age',education','major','number','experience','salary') values(?,?,?,?,?,?,?,?)";//使用占位符定义插入语句
	  	try(Connection conn=dbcs.getConnection();//获取数据库接
	  		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	  		String name=textFieldXm.getText();
	  		String sex=s;
	  		String age=textFieldNl.getText();
	  		String education=textFieldEducation.getText();
	  		String major=textFieldMajor.getText();
	  		String number=textFieldNumber.getText();
	  		String experience=textFieldExperience.getText();
	  		String salary=textFieldSalary.getText();
	  		pstmt.setString(1, name);//定义第1个占位符的内容
    		pstmt.setString(2, sex);//定义第2个占位符的内容
    		pstmt.setString(3, age);//定义第2个占位符的内容
    		pstmt.setString(4, education);//定义第2个占位符的内容
    		pstmt.setString(5, major);//定义第2个占位符的内容
    		pstmt.setString(6, number);//定义第2个占位符的内容
    		pstmt.setString(7, experience);//定义第2个占位符的内容
    		pstmt.setString(8, salary);//定义第2个占位符的内容
    		pstmt.executeUpdate();//执行一条插入语句
	  		
	  	} catch (SQLException e) {
			e.printStackTrace();
		}
  }
	
}
