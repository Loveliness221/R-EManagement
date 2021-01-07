package jsu.cmd.registe;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import jsu.cmd.connection.DataConnectionMysql;
import javax.swing.ImageIcon;
/**
 * 初始化查看个人中心资料
 * @author Think
 *
 */
public class PerCenterWindow extends JFrame{

	JLabel label_Xm = new JLabel("");
	JLabel label_Xb = new JLabel("");
	JLabel label_Nl = new JLabel("");
	JLabel label_Num = new JLabel("");
	JLabel label_Xl = new JLabel("");
	JLabel label_Sm = new JLabel("");
	JLabel label_Zh = new JLabel("");
	public PerCenterWindow() {
		}
	public void initCenter(){
		JFrame frame4=new JFrame();
		frame4.getContentPane().setFont(new Font("宋体", Font.PLAIN, 18));
		frame4.setSize(449,666);
		frame4.setLocationRelativeTo(null);//居中显示
		frame4.getContentPane().setBackground(new Color(255, 218, 185));
		frame4.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("\u59D3\u540D\uFF1A");
		lblName.setFont(new Font("宋体", Font.PLAIN, 18));
		lblName.setBounds(49, 38, 72, 29);
		frame4.getContentPane().add(lblName);
		
		JLabel lblSex = new JLabel("\u6027\u522B\uFF1A");
		lblSex.setFont(new Font("宋体", Font.PLAIN, 18));
		lblSex.setBounds(49, 95, 54, 32);
		frame4.getContentPane().add(lblSex);
		
		JLabel lblAge = new JLabel("\u5E74\u9F84\uFF1A");
		lblAge.setFont(new Font("宋体", Font.PLAIN, 18));
		lblAge.setBounds(49, 159, 54, 32);
		frame4.getContentPane().add(lblAge);
		
		JLabel lblNum = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		lblNum.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNum.setBounds(48, 284, 107, 32);
		frame4.getContentPane().add(lblNum);
		
		JLabel lblIntro = new JLabel("\u81EA\u6211\u8BF4\u660E\uFF1A");
		lblIntro.setFont(new Font("宋体", Font.PLAIN, 18));
		lblIntro.setBounds(49, 415, 95, 33);
		frame4.getContentPane().add(lblIntro);
		
		JLabel lblStudy = new JLabel("\u5B66\u5386\uFF1A");
		lblStudy.setFont(new Font("宋体", Font.PLAIN, 18));
		lblStudy.setBounds(49, 350, 72, 29);
		frame4.getContentPane().add(lblStudy);
		label_Xm.setFont(new Font("宋体", Font.PLAIN, 18));
		
		getData(label_Xm, label_Xb, label_Nl, label_Zh,label_Num,label_Xl,label_Sm);
		label_Xm.setBounds(117, 38, 156, 29);
		frame4.getContentPane().add(label_Xm);
		label_Xb.setFont(new Font("宋体", Font.PLAIN, 18));
		

		label_Xb.setBounds(117, 95, 156, 32);
		frame4.getContentPane().add(label_Xb);
		label_Nl.setFont(new Font("宋体", Font.PLAIN, 18));
		
		
		label_Nl.setBounds(117, 159, 156, 32);
		frame4.getContentPane().add(label_Nl);
		label_Num.setFont(new Font("宋体", Font.PLAIN, 18));
		
		 
		label_Num.setBounds(162, 284, 156, 32);
		frame4.getContentPane().add(label_Num);
		label_Xl.setFont(new Font("宋体", Font.PLAIN, 18));
		
	   
		label_Xl.setBounds(117, 350, 156, 29);
		frame4.getContentPane().add(label_Xl);
		label_Sm.setFont(new Font("宋体", Font.PLAIN, 18));
		
		label_Sm.setBounds(150, 420, 202, 171);
		frame4.getContentPane().add(label_Sm);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(49, 221, 72, 29);
		frame4.getContentPane().add(lblNewLabel);
		label_Zh.setFont(new Font("宋体", Font.PLAIN, 18));
		
		label_Zh.setBounds(117, 221, 156, 29);
		frame4.getContentPane().add(label_Zh);
		frame4.setTitle("个人中心");
		frame4.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7602\\r1.png"));
		frame4.setBackground(new Color(255, 218, 185));
		frame4.setVisible(true);
		
		
	}
	/**
	 * 记录登录界面账户输入框内容
	 * 写入文件
	 * @param textFieldZh
	 * @throws IOException
	 */
	public void ac(JTextField textFieldZh) throws 
IOException
	{
		
		File f=new File("d://我的文档大学/text.txt");
		if(!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		FileWriter writer=new FileWriter(f);
		writer.write(textFieldZh.getText());//写入输入的账号
		writer.flush();
		writer.close();
	}
	/**
	 * 从文件读出登录文本框输入的内容
	 * @param s
	 * @return
	 * @throws IOException
	 */
	public String readAc(String s) throws IOException
	{
		File f=new File("d://我的文档大学/text.txt");
		FileReader reader=new FileReader(f);
		try {
			BufferedReader output=new BufferedReader(reader);
			s=output.readLine();//读取第一行
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return s;
			
	}
	/**
	 * 从数据库个人简历信息表中读取信息
	 * @param label_Xm
	 * @param label_Xb
	 * @param label_Nl
	 * @param label_Zh
	 * @param label_Num
	 * @param label_Xl
	 * @param label_Sm
	 */
	public void getData(JLabel label_Xm ,JLabel label_Xb ,JLabel label_Nl ,JLabel label_Zh ,JLabel label_Num ,JLabel label_Xl,JLabel label_Sm) 
	{
		DataConnectionMysql dbcs=new DataConnectionMysql();//使用定义的连接数据库的类
	  	String sql="select * from 个人简历信息";
	  	String s = null;
	 try(Connection conn=dbcs.getConnection();//获取数据库连接
	  		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	  		ResultSet rs=pstmt.executeQuery(sql);//获得查询结果集
				s=readAc(s);
	  		while(rs.next())
	  		{
	  			if(rs.getString(4)!=null&&s!=null)
	  			{
	  			if(rs.getString(4).trim().equals(s.trim()))//找到登录的账号
	  			{
	  			label_Xm.setText(rs.getString(1));
	  			label_Xb.setText(rs.getString(2));
	  			label_Nl.setText(rs.getString(3));
	  			label_Zh.setText(s);//从文件读取与从数据库读取账号相同
	  			label_Num.setText(rs.getString(5));
	  			label_Xl.setText(rs.getString(6));
	  			label_Sm.setText(rs.getString(7));
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