package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * ���û���д����Ƹ��Ϣ���������ݿ���Ƹ��Ϣ��
 * @author Think
 *
 */
public class PostRecruitment {
	 public void addCom(JTextField textFieldZw,JTextField textFieldXz,JTextField textFieldQym,JTextField textFieldQydz)
	  {
		  DataConnectionMysql dbcs=new DataConnectionMysql();//ʹ�ö�����������ݿ����
		  //������ھ���Ƹ����ģ������������
		  	String sql="replace into ��Ƹ��Ϣ('position','salary','company','address') values(?,?,?,?,)";//ʹ��ռλ������������
		  	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
		  		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
		  		String position=textFieldZw.getText();
		  		String salary=textFieldXz.getText();
		  		String company=textFieldQym.getText();
		  		String address=textFieldQydz.getText();
		  		pstmt.setString(1, position);//�����1��ռλ��������
	    		pstmt.setString(2, salary);//�����2��ռλ��������
	    		pstmt.setString(3, company);//�����2��ռλ��������
	    		pstmt.setString(4, address);//�����2��ռλ��������
	    		pstmt.executeUpdate();//ִ��һ���������
		  		
		  	} catch (SQLException e) {
				e.printStackTrace();
			}
}
}
