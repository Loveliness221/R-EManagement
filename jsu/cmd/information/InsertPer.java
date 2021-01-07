package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * 将用户填写的注册信息插入至用户账户及用户简历信息数据表
 * @author Think
 *
 */
public class InsertPer {
	
     public InsertPer() {}
     /**
      * 随机返回指定范围内的整数
      * @param start
      * @param end
      * @return
      */
     public  int getNum(int start,int end) {//随机返回指定范围间的整数
	        return (int)(Math.random()*(end-start+1)+start);}
     //随机返回账号
     /**
      * 随机生成注册用户的账号
      * @return
      */
     public StringBuilder getAccount() {//不使用String，因为需要大量拼接字符串
    	 
     	StringBuilder ac=new StringBuilder("dd2019");//账号前六位有相同
     	StringBuilder ac1=new StringBuilder(String.valueOf(getNum(1,9999)));//随机取后4位
     	if(ac1.length()==1) {
     		ac1=ac1.insert(0, "000");//如果是1位数，前面增加3个0
     		ac=ac.append(ac1);//前6位与后4位拼接成账号
     	}
     	else if(ac1.length()==2)//如果是两位数
     	{
     		ac1=ac1.insert(0, "00");//如果是2位数，前面增加2个0
     		ac=ac.append(ac1);
     	}
     	else if(ac1.length()==3)//如果是两位数
     	{
     		ac1=ac1.insert(0, "0");//如果是3位数，前面增加1个0
     		ac=ac.append(ac1);
     	}
     	else {
     		ac=ac.append(ac1);
     	}
     	return ac;
     }
     /**
      * 判断是个人用户
      * 记录选择插入的数据库表的SQL语句
      * @param remark1
      * @param remark2
      */
     public void checkInputP(JLabel remark1,JLabel remark2)//如果是个人账户
	  {
		  remark1.setText("replace into 个人简历信息(name,account,sex,number,introduce) values(?,?,?,?,?)");
		  remark2.setText("replace into 个人账户(account,password) values(?,?)");
	  }
     /**
      * 判断是企业用户
      * 记录选择插入的数据库表的SQL语句
      */
	  public void checkInputC(JLabel remark1,JLabel remark2)//如果是企业账户
	  {
		  remark1.setText("replace into 企业简历信息(name,account,sex,number,introduce) values(?,?,?,?,?)");
		  remark2.setText("replace into 企业账户(account,password) values(?,?)");
	  }
     //将个人信息插入到简历
	  /**
	   * 将注册信息插入到简历信息表
	   * @param textFieldNc
	   * @param lblaccount
	   * @param remark1
	   * @throws SQLException
	   */
	public  void addResume(JTextField textFieldNc,JLabel lblaccount,JLabel remark1) throws SQLException {//增加到数据库
	  	DataConnectionMysql dbcs=new DataConnectionMysql();//使用定义的连接数据库的类
	  	String sql=remark1.getText();//使用占位符定义插入语句
	  	try(Connection conn=dbcs.getConnection();//获取数据库接
	  		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	  			String account=getAccount().toString();
	  				String name=textFieldNc.getText();
	  				String sex="点击完善信息";
	  				int age=0;
	  				String number="点击完善信息";
	  				String education="点击完善信息";
	  				String introduce="点击完善信息";
	  				pstmt.setString(1, name);//定义第1个占位符的内容
	  	    		pstmt.setString(2, sex);//定义第2个占位符的内容
	  	    		pstmt.setInt(3, age);//定义第3个占位符的内容
	  	    		pstmt.setString(4, account);
	  	    		pstmt.setString(5, number);//定义第4个占位符的内容
	  	    		pstmt.setString(6, education);
	  	    		pstmt.setString(7,introduce);
	  	    		lblaccount.setText(account);//记录下随机生成的账号
	  	    		pstmt.executeUpdate();//执行插入语句
	  			}
	}
	//将注册信息插入到账户
	/**
	 * 将注册信息插入到账户信息表
	 * @param lblaccount
	 * @param TextFieldMm
	 * @param remark2
	 * @throws SQLException
	 */
	  public void addAccountPass(JLabel lblaccount,JTextField TextFieldMm,JLabel remark2) throws SQLException {//增加到数据库
	    	DataConnectionMysql dbcs=new DataConnectionMysql();//使用定义的连接数据库的类
	    	String sql=remark2.getText();//使用占位符定义插入语句
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    			String account=lblaccount.getText();//随机获取账号
	    				String password=TextFieldMm.getText();//随机获取密码
	    				pstmt.setString(1, account);//定义第1个占位符的内容
	    	    		pstmt.setString(2, password);//定义第2个占位符的内容
	    	    		pstmt.executeUpdate();//执行插入语句
	    			}
	    		}
	  
}
