package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JOptionPane;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * ���������ְ����Ϣ
 * @author Think
 *
 */
public class PerEmploy {

	public static void main(String[] args) {
		add();
	}
	public static int getNum(int start,int end) {//�������ָ����Χ�������
        return (int)(Math.random()*(end-start+1)+start);
    }
	/**
	 * �����������
	 * @return
	 */
	public static String getName() {
		String firstName="��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
		//����Ů������
		String girl="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
		//������������
	    String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
	        int index=getNum(0, firstName.length()-1);//���ȡ�����ַ����е�����λ��
	        String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
	        int sex=getNum(0,1);//���ȡ�Ա�����1Ϊ������0ΪŮ��
	        String str=boy;//��������Ϊ�����ַ���
	        int length=boy.length();//��ȡ�����ַ����ĳ���
	        if(sex==0){//��������ȡΪ0�������ָ�ΪŮ��
	            str=girl;
	            length=girl.length();
	        }
	        index=getNum(0,length-1);//�����ȡ���ֵ�λ��
	        String second=str.substring(index, index+1);//��ȡ��λ���е�����
	        int hasThird=getNum(0,1);//�����ȡ�����Ƿ��е�������
	        String third="";//Ĭ��û�е�������
	        if(hasThird==1){//��������ȡΪ1�����е�������
	            index=getNum(0,length-1);
	            third=str.substring(index, index+1);
	        }
	        return first+second+third;//��������
	    }
    /**
     * �������Ա�
     * @return
     */
    public static String getSex(){
    	int sex=getNum(0,1);
    	if(sex==0)
    	{
    		return "Ů";
    	}
    	else return "��";
    }
    /**
     * �����ȡ�绰����
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
     * �������ѧ��
     * @return
     */
    public static String getEducation() {
  	  int flag=getNum(0, 3);
  	  if(flag==0)
  		  return"ר��";
  	  else if(flag==1)
  		  return "����";
  	  else if(flag==2)
  		  return "�о���";
  	  else return "��ʿ";
    }
    /**
     * �����������н��
     * @return
     */
    public static String getSalary() {
  	 StringBuilder in=new StringBuilder("����н�ʣ�");
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
     * �������רҵ
     * @return
     */
    public static String getMajor() {
    	String[] major= {"�������","ƽ�����","�������","�˹�����","Ӱ����Ӱ","�������","��װ���","��������ý��","�Ƶ����","����","��������ѧ����","Ӧ�û�ѧ","��ľ����"};
    	int index=getNum(0, 12);
    	return major[index];
    }
    /**
     * �����ù�������
     * @return
     */
    public static String getExperience() {
    	StringBuilder ex=new StringBuilder("��");
    	StringBuilder ex1=new StringBuilder(String.valueOf(getNum(1, 10)));
    	return ex1.append(ex).toString();
    	
    }
    /**
     * ��������ɵ���ְ��Ϣ���뵽��ְ��Ϣ��
     */
    public static void add() {//���ӵ����ݿ�
      	DataConnectionMysql dbcs=new DataConnectionMysql();//ʹ�ö�����������ݿ����
      	String sql="insert into ��ְ��Ϣ(name,sex,age,education,major,number,salary,experience) values(?,?,?,?,?,?,?,?)";//ʹ��ռλ������������
      	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
      		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
      		for(int i=1;i<=9;) {
      				String name=getName();//��ȡ����
      				String sex=getSex();
      				String age=String.valueOf(getNum(20, 45));
      				String education=getEducation();
      				String major=getMajor();
      				String number=getNumber().toString();
      				String salary=getSalary();
      				String experience=getExperience();
      				pstmt.setString(1, name);//�����1��ռλ��������
      	    		pstmt.setString(2, sex);//�����2��ռλ��������
      	    		pstmt.setString(3,age);
      	    		pstmt.setString(4, education);
      	    		pstmt.setString(5, major);
      	    		pstmt.setString(6, number);
      	    		pstmt.setString(7, salary);
      	    		pstmt.setString(8, experience);
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
