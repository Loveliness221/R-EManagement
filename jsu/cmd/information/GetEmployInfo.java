package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextArea;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * �������ݿ���ְ��Ϣ����ʾ����ҵ�˻�����
 * @author Think
 *
 */
public class GetEmployInfo {
/**
 * �������ı�����ʾ���ݿ�����ְ��Ϣ������
 * @param textArea
 */
	public void getInfo(JTextArea textArea) {
		String s="",s1;
		 DataConnectionMysql dbcs=new DataConnectionMysql();//ʹ�ö�����������ݿ����
		  String sql="select * from ��ְ��Ϣ";//��ò�ѯ���
		 try( Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
		  PreparedStatement ps=conn.prepareStatement(sql);){//��ȡ����SQL�����������
		  ResultSet rs=ps.executeQuery(sql);//��ò�ѯ�����
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
			s1=name+"  "+sex+"   "+age+"\n"+education+"   "+major+"רҵ\n�绰���룺"+number+"\n�������飺"+experience+"\n"+salary+"\n\n";
			s+=s1;
		}
		
		 }catch (SQLException e) {
			e.printStackTrace();
		}
		textArea.setText(s);
	}
}
