package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * ���û���д�������������ݿ�
 * @author Think
 *
 */
public class ReleaResume {
	String s;
	/**
	 * �����ж��û��Ա�
	 */
  public void CheckMan()
  {
	  s="��";
  }
  public void CheckWoman() {
	  s="Ů";
  }
  public void addPer(JTextField textFieldXm,JTextField textFieldNl,JTextField textFieldMajor,JTextField textFieldEducation,JTextField textFieldNumber,JTextField textFieldSalary,JTextField textFieldExperience)
  {
	  DataConnectionMysql dbcs=new DataConnectionMysql();//ʹ�ö�����������ݿ����
	  //������ھɼ�������ģ������������
	  	String sql="replace into ��ְ��Ϣ('name','sex','age',education','major','number','experience','salary') values(?,?,?,?,?,?,?,?)";//ʹ��ռλ������������
	  	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	  		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	  		String name=textFieldXm.getText();
	  		String sex=s;
	  		String age=textFieldNl.getText();
	  		String education=textFieldEducation.getText();
	  		String major=textFieldMajor.getText();
	  		String number=textFieldNumber.getText();
	  		String experience=textFieldExperience.getText();
	  		String salary=textFieldSalary.getText();
	  		pstmt.setString(1, name);//�����1��ռλ��������
    		pstmt.setString(2, sex);//�����2��ռλ��������
    		pstmt.setString(3, age);//�����2��ռλ��������
    		pstmt.setString(4, education);//�����2��ռλ��������
    		pstmt.setString(5, major);//�����2��ռλ��������
    		pstmt.setString(6, number);//�����2��ռλ��������
    		pstmt.setString(7, experience);//�����2��ռλ��������
    		pstmt.setString(8, salary);//�����2��ռλ��������
    		pstmt.executeUpdate();//ִ��һ���������
	  		
	  	} catch (SQLException e) {
			e.printStackTrace();
		}
  }
	
}
