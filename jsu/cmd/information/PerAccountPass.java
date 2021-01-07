package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * ������ɸ����˻���Ϣ
 * @author Think
 *
 */

public class PerAccountPass {
	private static String source="0123456789abcdefghijklmnopqrstuvwxyz";
	public static void main(String args[]) {
		getAccount();//��������˺�
		getPassword();//�����������
		add();
		
	}
	 public static int getNum(int start,int end) {//�������ָ����Χ�������
	        return (int)(Math.random()*(end-start+1)+start);
	    }
	    /**
	     * ��������˺�
	     * @return
	     */
	    public static StringBuilder getAccount() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
	    	StringBuilder ac=new StringBuilder("dd2021");//�˺�ǰ��λ����ͬ
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
	     * �����������
	     * @return
	     */
	    public static String getPassword() {
	    	StringBuffer pass=new StringBuffer();
	    	Random random=new Random();
	    	for(int i=0;i<8;i++)
	    	{
	    		int len=source.length();//����ַ�����Դ����
	    		int index=random.nextInt(len);//�����ȡ�ַ�λ��
	    		char pass1=source.charAt(index);//����ַ�
	    		pass.append(pass1);//ƴ���ַ���
	    	}
	    	return pass.toString();//�����������
	    }
	    /**
	     * ��������ɵĸ����˻���Ϣ�����������˻���
	     */
	    public static void add() {//���ӵ����ݿ�
	    	DataConnectionMysql dbcs=new DataConnectionMysql();//ʹ�ö�����������ݿ����
	    	String sql="insert into �����˻�(account,password) values(?,?)";//ʹ��ռλ������������
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	        	ArrayList<String> alist=new ArrayList<String>();//���弯��
	    		for(int i=1;i<=5;) {
	    			String account=getAccount().toString();//�����ȡ�˺�
	    			if(!alist.contains(account)) {//�ж��˺��Ƿ�Ψһ
	    				alist.add(account);//���˺ż��뼯��
	    				String password=getPassword();//�����ȡ����
	    				pstmt.setString(1, account);//�����1��ռλ��������
	    	    		pstmt.setString(2, password);//�����2��ռλ��������
	    	    		pstmt.addBatch();//����������ȴ�ִ��
	    				i++;//�˺�Ψһ��ѭ����������ִ��
	    			}
	    		}
	    		pstmt.executeBatch();//����ִ�в������
	    		dbcs.close();
	    		JOptionPane.showMessageDialog(null, "sucess!!!");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
}
