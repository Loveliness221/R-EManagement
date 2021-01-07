package jsu.cmd.registe;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * 初始化个人中心窗体
 * 查看用户资料
 * @author Think
 *
 */
public class ComCenterWindow extends JFrame{
	JLabel lblNewLabelName = new JLabel("");
	JLabel lblNewLabelZh = new JLabel("");
	JLabel lblNewLabelDh = new JLabel("");
	JLabel lblNewLabelDz = new JLabel("");
	public ComCenterWindow() {}
	public void initCom() {

    	JFrame frame7=new JFrame("个人中心");
    	frame7.setSize(500,500);
		frame7.getContentPane().setFont(new Font("宋体", Font.PLAIN, 18));
		setBackground(new Color(255, 218, 185));
		frame7.getContentPane().setBackground(new Color(255, 218, 185));
		frame7.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("\u4F01\u4E1A\u540D\uFF1A");
		lblName.setFont(new Font("宋体", Font.PLAIN, 18));
		lblName.setBounds(69, 79, 72, 34);
		frame7.getContentPane().add(lblName);
		
		 getData(lblNewLabelName, lblNewLabelZh, lblNewLabelDh, lblNewLabelDz);
		lblNewLabelName.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabelName.setBounds(146, 73, 288, 40);
		frame7.getContentPane().add(lblNewLabelName);
		
		JLabel lblNewLabel_1 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(69, 254, 95, 34);
		frame7.getContentPane().add(lblNewLabel_1);
		
		lblNewLabelZh.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabelZh.setBounds(164, 160, 270, 40);
		frame7.getContentPane().add(lblNewLabelZh);
		
		JLabel lblNewLabel_3 = new JLabel("\u4F01\u4E1A\u5730\u5740\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(69, 345, 95, 47);
		frame7.getContentPane().add(lblNewLabel_3);
		
		lblNewLabelDh.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabelDh.setBounds(178, 241, 256, 47);
		frame7.getContentPane().add(lblNewLabelDh);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(69, 160, 72, 40);
		frame7.getContentPane().add(lblNewLabel);
		
		lblNewLabelDz.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabelDz.setBounds(178, 345, 256, 47);
		frame7.getContentPane().add(lblNewLabelDz);
		setTitle("\u4E2A\u4EBA\u4E2D\u5FC3");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7602\\r1.png"));
	 //  getData(lblNewLabelName, lblNewLabelZh, lblNewLabelDh, lblNewLabelDz);
		frame7.setLocationRelativeTo(null);
    	frame7.setVisible(true);
    }
	/**
	 * 从数据库企业简历信息表中获取个人中心模块资料
	 * @param lblNewLabelName
	 * @param lblNewLabelZh
	 * @param lblNewLabelDh
	 * @param lblNewLabelDz
	 */
	public void getData(JLabel lblNewLabelName ,JLabel lblNewLabelZh,JLabel lblNewLabelDh ,JLabel lblNewLabelDz) 
	{
		DataConnectionMysql dbcs=new DataConnectionMysql();//使用定义的连接数据库的类
	  	String sql="select * from 企业简历信息";
	  	String s = null;
	  	PerCenterWindow p=new PerCenterWindow();
	 try(Connection conn=dbcs.getConnection();//获取数据库连接
	  		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	  		ResultSet rs=pstmt.executeQuery(sql);//获得查询结果集
				s=p.readAc(s);
	  		while(rs.next())
	  		{
	  			if(rs.getString(2)!=null&&s!=null)
	  			{
	  			if(rs.getString(2).trim().equals(s.trim()))//找到登录的账号
	  			{
	  			lblNewLabelName.setText(rs.getString(1));
	  			lblNewLabelZh.setText(rs.getString(2));
	  			lblNewLabelDh.setText(rs.getString(3));
	  			lblNewLabelDz.setText(rs.getString(4));
	  			break;
	  			}
	  		}
	  		}
	  		rs.close();
	  		pstmt.close();
	}catch(SQLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
