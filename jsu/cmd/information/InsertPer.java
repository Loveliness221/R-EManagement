package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * ���û���д��ע����Ϣ�������û��˻����û�������Ϣ���ݱ�
 * @author Think
 *
 */
public class InsertPer {
	
     public InsertPer() {}
     /**
      * �������ָ����Χ�ڵ�����
      * @param start
      * @param end
      * @return
      */
     public  int getNum(int start,int end) {//�������ָ����Χ�������
	        return (int)(Math.random()*(end-start+1)+start);}
     //��������˺�
     /**
      * �������ע���û����˺�
      * @return
      */
     public StringBuilder getAccount() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
    	 
     	StringBuilder ac=new StringBuilder("dd2019");//�˺�ǰ��λ����ͬ
     	StringBuilder ac1=new StringBuilder(String.valueOf(getNum(1,9999)));//���ȡ��4λ
     	if(ac1.length()==1) {
     		ac1=ac1.insert(0, "000");//�����1λ����ǰ������3��0
     		ac=ac.append(ac1);//ǰ6λ���4λƴ�ӳ��˺�
     	}
     	else if(ac1.length()==2)//�������λ��
     	{
     		ac1=ac1.insert(0, "00");//�����2λ����ǰ������2��0
     		ac=ac.append(ac1);
     	}
     	else if(ac1.length()==3)//�������λ��
     	{
     		ac1=ac1.insert(0, "0");//�����3λ����ǰ������1��0
     		ac=ac.append(ac1);
     	}
     	else {
     		ac=ac.append(ac1);
     	}
     	return ac;
     }
     /**
      * �ж��Ǹ����û�
      * ��¼ѡ���������ݿ���SQL���
      * @param remark1
      * @param remark2
      */
     public void checkInputP(JLabel remark1,JLabel remark2)//����Ǹ����˻�
	  {
		  remark1.setText("replace into ���˼�����Ϣ(name,account,sex,number,introduce) values(?,?,?,?,?)");
		  remark2.setText("replace into �����˻�(account,password) values(?,?)");
	  }
     /**
      * �ж�����ҵ�û�
      * ��¼ѡ���������ݿ���SQL���
      */
	  public void checkInputC(JLabel remark1,JLabel remark2)//�������ҵ�˻�
	  {
		  remark1.setText("replace into ��ҵ������Ϣ(name,account,sex,number,introduce) values(?,?,?,?,?)");
		  remark2.setText("replace into ��ҵ�˻�(account,password) values(?,?)");
	  }
     //��������Ϣ���뵽����
	  /**
	   * ��ע����Ϣ���뵽������Ϣ��
	   * @param textFieldNc
	   * @param lblaccount
	   * @param remark1
	   * @throws SQLException
	   */
	public  void addResume(JTextField textFieldNc,JLabel lblaccount,JLabel remark1) throws SQLException {//���ӵ����ݿ�
	  	DataConnectionMysql dbcs=new DataConnectionMysql();//ʹ�ö�����������ݿ����
	  	String sql=remark1.getText();//ʹ��ռλ������������
	  	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	  		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	  			String account=getAccount().toString();
	  				String name=textFieldNc.getText();
	  				String sex="���������Ϣ";
	  				int age=0;
	  				String number="���������Ϣ";
	  				String education="���������Ϣ";
	  				String introduce="���������Ϣ";
	  				pstmt.setString(1, name);//�����1��ռλ��������
	  	    		pstmt.setString(2, sex);//�����2��ռλ��������
	  	    		pstmt.setInt(3, age);//�����3��ռλ��������
	  	    		pstmt.setString(4, account);
	  	    		pstmt.setString(5, number);//�����4��ռλ��������
	  	    		pstmt.setString(6, education);
	  	    		pstmt.setString(7,introduce);
	  	    		lblaccount.setText(account);//��¼��������ɵ��˺�
	  	    		pstmt.executeUpdate();//ִ�в������
	  			}
	}
	//��ע����Ϣ���뵽�˻�
	/**
	 * ��ע����Ϣ���뵽�˻���Ϣ��
	 * @param lblaccount
	 * @param TextFieldMm
	 * @param remark2
	 * @throws SQLException
	 */
	  public void addAccountPass(JLabel lblaccount,JTextField TextFieldMm,JLabel remark2) throws SQLException {//���ӵ����ݿ�
	    	DataConnectionMysql dbcs=new DataConnectionMysql();//ʹ�ö�����������ݿ����
	    	String sql=remark2.getText();//ʹ��ռλ������������
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    			String account=lblaccount.getText();//�����ȡ�˺�
	    				String password=TextFieldMm.getText();//�����ȡ����
	    				pstmt.setString(1, account);//�����1��ռλ��������
	    	    		pstmt.setString(2, password);//�����2��ռλ��������
	    	    		pstmt.executeUpdate();//ִ�в������
	    			}
	    		}
	  
}
