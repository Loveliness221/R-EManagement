package jsu.cmd.registe;

import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.Connection;

import jsu.cmd.connection.DataConnectionMysql;

import javax.swing.*;
/**
 * 判断账号登录
 * @author Think
 *
 */
public class DetermineInput{
/**
 * 判断账号是否为空
 * @param t
 * @param lblMsgZh
 * @return
 */
	public boolean checkInputZh(JTextField t,JLabel lblMsgZh) //判断账号是否为空
	{
		  if(t.getText().length()==0) {//获取账号输入框的内容长度
		    lblMsgZh.setText("账号不能为空");//设置警告信息
		    t.requestFocus();//账号输入框获取焦点
		    return false;
		  }
		  else{lblMsgZh.setText("");
		  return true;
		  }
	}
	/**
	 * 判断密码是否为空
	 * @param p
	 * @param lblMsgMm
	 * @return
	 */
		  public boolean checkInputPass(JPasswordField p,JLabel lblMsgMm)//判断密码是否为空 
		  {
		  if(p.getPassword().length==0) {//获取账号输入框的内容长度
			    lblMsgMm.setText("密码不能为空");//设置警告信息
			    p.requestFocus();//密码输入框获取焦点
			    return false;
			  }
			  else{lblMsgMm.setText("");
			  return true;
			  }
	}
		  /**
		   * 监听是否为个人账户
		   * 若为个人账户记录SQL从个人账户数据库表中查
		   * @param remark
		   */
		  public void checkInputP(JLabel remark)//如果是个人账户
		  {
			  remark.setText("select * from 个人账户");
		  }
		  /**
		   * 监听是否为企业账户
		   * 若为企业账户记录SQL从企业账户数据表中查
		   * @param remark
		   */
		  public void checkInputC(JLabel remark)//如果是企业账户
		  {
			  remark.setText("select * from 企业账户");
		  }
		  /**
		   * 判断账号是否存在以及密码是否正确
		   * 不存在或不正确给出红色提醒
		   * @param t
		   * @param p
		   * @param lblMsgZh
		   * @param lblMsgMm
		   * @param lblremark
		   * @return
		   * @throws SQLException
		   */
		  public boolean checkInputRight(JTextField t,JPasswordField p,JLabel lblMsgZh,JLabel lblMsgMm,JLabel lblremark) throws SQLException
		  {
			  DataConnectionMysql dbcs=new DataConnectionMysql();//使用定义的连接数据库的类
			  String sql=lblremark.getText();//获得查询语句
			  Connection conn=dbcs.getConnection();//获取数据库连接
			  PreparedStatement ps=conn.prepareStatement(sql);//获取处理SQL语句的命令对象
			  ResultSet rs=ps.executeQuery(sql);//获得查询结果集
			  int flag=1;
			 while(rs.next()&&flag==1)//获得当前结果集的一列的数据,遍历结果集
			  {
				  String account=rs.getString("account");
				  String password=rs.getString("password");
				 // lblMsgZh.setText(account);
				//  lblMsgMm.setText(password);
			  if(account.trim().equals(t.getText()))//如果存在账号与输入的账号相同
			  {
			  String password2 = new String(p.getPassword());
			if(!password.trim().equals(password2))//则判断密码是否正确
			  {
			  lblMsgZh.setText("");
				 lblMsgMm.setText("密码错误");
				  flag=1;
			  }
			  else{lblMsgZh.setText("");
			  lblMsgMm.setText("");
			  flag=0;
			  }
			  }
			  else {
				  lblMsgZh.setText("用户不存在");
				  lblMsgMm.setText("");
				  flag=1;
		  }
}
			 rs.close();
			 ps.close();
			  if(flag==1)
			  return false;
			  else 
				  return true;
}
}
