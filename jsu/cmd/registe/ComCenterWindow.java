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
 * ��ʼ���������Ĵ���
 * �鿴�û�����
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

    	JFrame frame7=new JFrame("��������");
    	frame7.setSize(500,500);
		frame7.getContentPane().setFont(new Font("����", Font.PLAIN, 18));
		setBackground(new Color(255, 218, 185));
		frame7.getContentPane().setBackground(new Color(255, 218, 185));
		frame7.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("\u4F01\u4E1A\u540D\uFF1A");
		lblName.setFont(new Font("����", Font.PLAIN, 18));
		lblName.setBounds(69, 79, 72, 34);
		frame7.getContentPane().add(lblName);
		
		 getData(lblNewLabelName, lblNewLabelZh, lblNewLabelDh, lblNewLabelDz);
		lblNewLabelName.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabelName.setBounds(146, 73, 288, 40);
		frame7.getContentPane().add(lblNewLabelName);
		
		JLabel lblNewLabel_1 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(69, 254, 95, 34);
		frame7.getContentPane().add(lblNewLabel_1);
		
		lblNewLabelZh.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabelZh.setBounds(164, 160, 270, 40);
		frame7.getContentPane().add(lblNewLabelZh);
		
		JLabel lblNewLabel_3 = new JLabel("\u4F01\u4E1A\u5730\u5740\uFF1A");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(69, 345, 95, 47);
		frame7.getContentPane().add(lblNewLabel_3);
		
		lblNewLabelDh.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabelDh.setBounds(178, 241, 256, 47);
		frame7.getContentPane().add(lblNewLabelDh);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel.setBounds(69, 160, 72, 40);
		frame7.getContentPane().add(lblNewLabel);
		
		lblNewLabelDz.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabelDz.setBounds(178, 345, 256, 47);
		frame7.getContentPane().add(lblNewLabelDz);
		setTitle("\u4E2A\u4EBA\u4E2D\u5FC3");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7602\\r1.png"));
	 //  getData(lblNewLabelName, lblNewLabelZh, lblNewLabelDh, lblNewLabelDz);
		frame7.setLocationRelativeTo(null);
    	frame7.setVisible(true);
    }
	/**
	 * �����ݿ���ҵ������Ϣ���л�ȡ��������ģ������
	 * @param lblNewLabelName
	 * @param lblNewLabelZh
	 * @param lblNewLabelDh
	 * @param lblNewLabelDz
	 */
	public void getData(JLabel lblNewLabelName ,JLabel lblNewLabelZh,JLabel lblNewLabelDh ,JLabel lblNewLabelDz) 
	{
		DataConnectionMysql dbcs=new DataConnectionMysql();//ʹ�ö�����������ݿ����
	  	String sql="select * from ��ҵ������Ϣ";
	  	String s = null;
	  	PerCenterWindow p=new PerCenterWindow();
	 try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
	  		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	  		ResultSet rs=pstmt.executeQuery(sql);//��ò�ѯ�����
				s=p.readAc(s);
	  		while(rs.next())
	  		{
	  			if(rs.getString(2)!=null&&s!=null)
	  			{
	  			if(rs.getString(2).trim().equals(s.trim()))//�ҵ���¼���˺�
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
