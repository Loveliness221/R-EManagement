package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * ��ȡ��Ƹ��Ϣ��������ʾ�������û�������
 * @author Think
 *
 */
public class GetJobInfor {
      /*
       * �������ݿ���Ƹ��Ϣ��
       * ����Ϊ�ı�������
       */
	public void getInfo(JTextArea textArea) {
		String s="",s1;
		 DataConnectionMysql dbcs=new DataConnectionMysql();//ʹ�ö�����������ݿ����
		  String sql="select * from ��Ƹ��Ϣ";//��ò�ѯ���
		 try( Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
		  PreparedStatement ps=conn.prepareStatement(sql);){//��ȡ����SQL�����������
		  ResultSet rs=ps.executeQuery(sql);//��ò�ѯ�����
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
