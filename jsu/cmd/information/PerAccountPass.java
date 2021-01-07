package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * 随机生成个人账户信息
 * @author Think
 *
 */

public class PerAccountPass {
	private static String source="0123456789abcdefghijklmnopqrstuvwxyz";
	public static void main(String args[]) {
		getAccount();//随机生成账号
		getPassword();//随机生成密码
		add();
		
	}
	 public static int getNum(int start,int end) {//随机返回指定范围间的整数
	        return (int)(Math.random()*(end-start+1)+start);
	    }
	    /**
	     * 随机返回账号
	     * @return
	     */
	    public static StringBuilder getAccount() {//不使用String，因为需要大量拼接字符串
	    	StringBuilder ac=new StringBuilder("dd2021");//账号前六位有相同
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
	     * 随机返回密码
	     * @return
	     */
	    public static String getPassword() {
	    	StringBuffer pass=new StringBuffer();
	    	Random random=new Random();
	    	for(int i=0;i<8;i++)
	    	{
	    		int len=source.length();//随机字符串资源长度
	    		int index=random.nextInt(len);//随机获取字符位置
	    		char pass1=source.charAt(index);//获得字符
	    		pass.append(pass1);//拼接字符串
	    	}
	    	return pass.toString();//返回随机密码
	    }
	    /**
	     * 将随机生成的个人账户信息插入至个人账户表
	     */
	    public static void add() {//增加到数据库
	    	DataConnectionMysql dbcs=new DataConnectionMysql();//使用定义的连接数据库的类
	    	String sql="insert into 个人账户(account,password) values(?,?)";//使用占位符定义插入语句
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	        	ArrayList<String> alist=new ArrayList<String>();//定义集合
	    		for(int i=1;i<=5;) {
	    			String account=getAccount().toString();//随机获取账号
	    			if(!alist.contains(account)) {//判断账号是否唯一
	    				alist.add(account);//将账号加入集合
	    				String password=getPassword();//随机获取密码
	    				pstmt.setString(1, account);//定义第1个占位符的内容
	    	    		pstmt.setString(2, password);//定义第2个占位符的内容
	    	    		pstmt.addBatch();//加入批处理等待执行
	    				i++;//账号唯一，循环继续往下执行
	    			}
	    		}
	    		pstmt.executeBatch();//批量执行插入操作
	    		dbcs.close();
	    		JOptionPane.showMessageDialog(null, "sucess!!!");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
}
