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
 * �ж��˺ŵ�¼
 * @author Think
 *
 */
public class DetermineInput{
/**
 * �ж��˺��Ƿ�Ϊ��
 * @param t
 * @param lblMsgZh
 * @return
 */
	public boolean checkInputZh(JTextField t,JLabel lblMsgZh) //�ж��˺��Ƿ�Ϊ��
	{
		  if(t.getText().length()==0) {//��ȡ�˺����������ݳ���
		    lblMsgZh.setText("�˺Ų���Ϊ��");//���þ�����Ϣ
		    t.requestFocus();//�˺�������ȡ����
		    return false;
		  }
		  else{lblMsgZh.setText("");
		  return true;
		  }
	}
	/**
	 * �ж������Ƿ�Ϊ��
	 * @param p
	 * @param lblMsgMm
	 * @return
	 */
		  public boolean checkInputPass(JPasswordField p,JLabel lblMsgMm)//�ж������Ƿ�Ϊ�� 
		  {
		  if(p.getPassword().length==0) {//��ȡ�˺����������ݳ���
			    lblMsgMm.setText("���벻��Ϊ��");//���þ�����Ϣ
			    p.requestFocus();//����������ȡ����
			    return false;
			  }
			  else{lblMsgMm.setText("");
			  return true;
			  }
	}
		  /**
		   * �����Ƿ�Ϊ�����˻�
		   * ��Ϊ�����˻���¼SQL�Ӹ����˻����ݿ���в�
		   * @param remark
		   */
		  public void checkInputP(JLabel remark)//����Ǹ����˻�
		  {
			  remark.setText("select * from �����˻�");
		  }
		  /**
		   * �����Ƿ�Ϊ��ҵ�˻�
		   * ��Ϊ��ҵ�˻���¼SQL����ҵ�˻����ݱ��в�
		   * @param remark
		   */
		  public void checkInputC(JLabel remark)//�������ҵ�˻�
		  {
			  remark.setText("select * from ��ҵ�˻�");
		  }
		  /**
		   * �ж��˺��Ƿ�����Լ������Ƿ���ȷ
		   * �����ڻ���ȷ������ɫ����
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
			  DataConnectionMysql dbcs=new DataConnectionMysql();//ʹ�ö�����������ݿ����
			  String sql=lblremark.getText();//��ò�ѯ���
			  Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
			  PreparedStatement ps=conn.prepareStatement(sql);//��ȡ����SQL�����������
			  ResultSet rs=ps.executeQuery(sql);//��ò�ѯ�����
			  int flag=1;
			 while(rs.next()&&flag==1)//��õ�ǰ�������һ�е�����,���������
			  {
				  String account=rs.getString("account");
				  String password=rs.getString("password");
				 // lblMsgZh.setText(account);
				//  lblMsgMm.setText(password);
			  if(account.trim().equals(t.getText()))//��������˺���������˺���ͬ
			  {
			  String password2 = new String(p.getPassword());
			if(!password.trim().equals(password2))//���ж������Ƿ���ȷ
			  {
			  lblMsgZh.setText("");
				 lblMsgMm.setText("�������");
				  flag=1;
			  }
			  else{lblMsgZh.setText("");
			  lblMsgMm.setText("");
			  flag=0;
			  }
			  }
			  else {
				  lblMsgZh.setText("�û�������");
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
