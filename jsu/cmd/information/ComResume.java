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
 * 随机生成企业简历信息
 * @author Think
 *
 */
public class ComResume {

	public static void main(String[] args) {
		add();

	}
	/**
	 * 随机生成企业名
	 * @return
	 */
    public static String getName() {
    	StringBuilder name=new StringBuilder("有限公司");
    	StringBuffer name1=new StringBuffer();
    	String source="刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
  	  Random random=new Random();
  	  for(int i=0;i<2;i++)
    	{
    		int len=source.length();//随机字符串资源长度
    		int index=random.nextInt(len);//随机获取字符位置
    		char name2=source.charAt(index);//获得字符
    		name1.append(name2);//拼接字符串
    	}
  	  name1.append(name);
  	  return name1.toString();//返回随机公司名字
    }
    //随机获取电话号码
    /**
     * 随机生成电话号码
     * @return
     */
    public static StringBuilder getNumber() {
  	  StringBuilder num=new StringBuilder("1");//第一位数相同
  	  String numbers="1234567890";
  	  Random random=new Random();
  	  for(int i=0;i<10;i++)
    	{
    		int len=numbers.length();//随机字符串资源长度
    		int index=random.nextInt(len);//随机获取字符位置
    		char num1=numbers.charAt(index);//获得字符
    		num.append(num1);//拼接字符串
    	}
  	  return num;
    }
    /**
     * 随机返回指定范围间的整数
     * @param start
     * @param end
     * @return
     */
    public static int getNum(int start,int end) {//随机返回指定范围间的整数
        return (int)(Math.random()*(end-start+1)+start);
    }
/**
 * 随机生成企业地址
 * @return
 */
    public static String getAddress() {
    	String[] address= {"北京","上海","广州","天津","南京","长沙","深圳","汕头","吉林","杭州","东莞","厦门","武汉"};
    	int index=getNum(0, 12);
    	return address[index];
    }
    //随机返回账号
    /**
     * 随机生成企业账号
     * @return
     */
    public static StringBuilder getAccount() {//不使用String，因为需要大量拼接字符串
    	StringBuilder ac=new StringBuilder("DD2021");//账号前六位有相同
    	StringBuilder ac1=new StringBuilder(String.valueOf(getNum(1,9999)));//随机取后4位
    	if(ac1.length()==1) {
    		ac1=ac1.insert(0, "000");//如果是1位数，前面增加3个0
    		ac=ac.append(ac1);//前6位与后4位拼接成账号
    	}
    	else if(ac1.length()==2)//如果是两位数
    	{
    		ac1=ac1.insert(0, "00");//如果是2位数，前面增加2个0
    		ac=ac.append(ac1);
    	}
    	else if(ac1.length()==3)//如果是两位数
    	{
    		ac1=ac1.insert(0, "0");//如果是3位数，前面增加1个0
    		ac=ac.append(ac1);
    	}
    	else {
    		ac=ac.append(ac1);
    	}
    	return ac;
    }
    /**
     * 将随机生成的企业信息插入到数据库企业简历信息表
     */
    public static void add() {//增加到数据库
      	DataConnectionMysql dbcs=new DataConnectionMysql();//使用定义的连接数据库的类
      	String sql="insert into 企业简历信息(name,account,number,address) values(?,?,?,?)";//使用占位符定义插入语句
      	try(Connection conn=dbcs.getConnection();//获取数据库接
      		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
      		for(int i=1;i<=1;) {
      				String name=getName();//随机获取名字
      				String account=getAccount().toString();
      				String number=getNumber().toString();
      				String address=getAddress();
      				pstmt.setString(1, name);//定义第1个占位符的内容
      				pstmt.setString(2, account);//定义第2个占位符的内容
      	    		pstmt.setString(3, number);//定义第3个占位符的内容
      	    		pstmt.setString(4,address);
      	    		pstmt.addBatch();//加入批处理等待执行
      				i++;//账号唯一，循环继续往下执行
      			}
			pstmt.executeBatch();//批量执行插入操作
      		dbcs.close();
      		JOptionPane.showMessageDialog(null, "sucess!!!");
      	}catch(SQLException e) {
      		e.printStackTrace();
      	}
      }
}
