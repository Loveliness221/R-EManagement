package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * ���������ҵ������Ϣ
 * @author Think
 *
 */
public class ComResume {

	public static void main(String[] args) {
		add();

	}
	/**
	 * ���������ҵ��
	 * @return
	 */
    public static String getName() {
    	StringBuilder name=new StringBuilder("���޹�˾");
    	StringBuffer name1=new StringBuffer();
    	String source="�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
  	  Random random=new Random();
  	  for(int i=0;i<2;i++)
    	{
    		int len=source.length();//����ַ�����Դ����
    		int index=random.nextInt(len);//�����ȡ�ַ�λ��
    		char name2=source.charAt(index);//����ַ�
    		name1.append(name2);//ƴ���ַ���
    	}
  	  name1.append(name);
  	  return name1.toString();//���������˾����
    }
    //�����ȡ�绰����
    /**
     * ������ɵ绰����
     * @return
     */
    public static StringBuilder getNumber() {
  	  StringBuilder num=new StringBuilder("1");//��һλ����ͬ
  	  String numbers="1234567890";
  	  Random random=new Random();
  	  for(int i=0;i<10;i++)
    	{
    		int len=numbers.length();//����ַ�����Դ����
    		int index=random.nextInt(len);//�����ȡ�ַ�λ��
    		char num1=numbers.charAt(index);//����ַ�
    		num.append(num1);//ƴ���ַ���
    	}
  	  return num;
    }
    /**
     * �������ָ����Χ�������
     * @param start
     * @param end
     * @return
     */
    public static int getNum(int start,int end) {//�������ָ����Χ�������
        return (int)(Math.random()*(end-start+1)+start);
    }
/**
 * ���������ҵ��ַ
 * @return
 */
    public static String getAddress() {
    	String[] address= {"����","�Ϻ�","����","���","�Ͼ�","��ɳ","����","��ͷ","����","����","��ݸ","����","�人"};
    	int index=getNum(0, 12);
    	return address[index];
    }
    //��������˺�
    /**
     * ���������ҵ�˺�
     * @return
     */
    public static StringBuilder getAccount() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
    	StringBuilder ac=new StringBuilder("DD2021");//�˺�ǰ��λ����ͬ
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
     * ��������ɵ���ҵ��Ϣ���뵽���ݿ���ҵ������Ϣ��
     */
    public static void add() {//���ӵ����ݿ�
      	DataConnectionMysql dbcs=new DataConnectionMysql();//ʹ�ö�����������ݿ����
      	String sql="insert into ��ҵ������Ϣ(name,account,number,address) values(?,?,?,?)";//ʹ��ռλ������������
      	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
      		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
      		for(int i=1;i<=1;) {
      				String name=getName();//�����ȡ����
      				String account=getAccount().toString();
      				String number=getNumber().toString();
      				String address=getAddress();
      				pstmt.setString(1, name);//�����1��ռλ��������
      				pstmt.setString(2, account);//�����2��ռλ��������
      	    		pstmt.setString(3, number);//�����3��ռλ��������
      	    		pstmt.setString(4,address);
      	    		pstmt.addBatch();//����������ȴ�ִ��
      				i++;//�˺�Ψһ��ѭ����������ִ��
      			}
			pstmt.executeBatch();//����ִ�в������
      		dbcs.close();
      		JOptionPane.showMessageDialog(null, "sucess!!!");
      	}catch(SQLException e) {
      		e.printStackTrace();
      	}
      }
}
