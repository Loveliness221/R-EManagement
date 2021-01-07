package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JOptionPane;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * ���������Ƹ��Ϣ
 * �����������ݿ���Ƹ��Ϣ��
 * @author Think
 *
 */
public class ComHire {

	public static void main(String[] args) {
		
      add();
	}
	/**
	 * �������ְλ
	 * @return
	 */
	public static String getPosition() {
    	String[] position= {"���۾���","�ܼ�","Java����ʦ","ǰ�����ʦ","ǰ̨","���","����ʦ","�廭ʦ","���ž���","����","��Ӱʦ","�������ʦ","ƽ�����ʦ"};
    	int index=getNum(0, 12);
    	return position[index];
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
	  * �������н��
	  * @return
	  */
	public static String getSalary() {
		 StringBuilder in=new StringBuilder("н�ʣ�");
		 StringBuilder in1=new StringBuilder(String.valueOf(getNum(2,5)));
		 StringBuilder in2=new StringBuilder("000-");
		 StringBuilder in3=new StringBuilder(String.valueOf(getNum(6,20)));
		 StringBuilder in4=new StringBuilder("000");
		 in.append(in1);
		 in.append(in2);
		 in.append(in3);
		 in.append(in4);
		 return in.toString();
		 
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
	/**
	 * ���������ҵ��ַ
	 * @return
	 */
	 public static String getAddress() {
	    	String[] address= {"����","�Ϻ�","����","���","�Ͼ�","��ɳ","����","��ͷ","����","����","��ݸ","����","�人"};
	    	int index=getNum(0, 12);
	    	return address[index];
	    }
	 /**
	  * ��������ɵ���Ƹ��Ϣ�������ݿ�����Ƹ��Ϣ��
	  */
	 public static void add() {//���ӵ����ݿ�
	      	DataConnectionMysql dbcs=new DataConnectionMysql();//ʹ�ö�����������ݿ����
	      	String sql="insert into ��Ƹ��Ϣ(position,salary,company,address) values(?,?,?,?)";//ʹ��ռλ������������
	      	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	      		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	      		for(int i=1;i<=9;) {
	      				String company=getName();//�����ȡ����
	      				String position=getPosition();
	      				String salary=getSalary();
	      				String address=getAddress();
	      				pstmt.setString(1, position);//�����1��ռλ��������
	      	    		pstmt.setString(2, salary);//�����2��ռλ��������
	      	    		pstmt.setString(3,company);
	      	    		pstmt.setString(4, address);
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
