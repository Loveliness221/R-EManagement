package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JOptionPane;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * 随机生成招聘信息
 * 并插入至数据库招聘信息表
 * @author Think
 *
 */
public class ComHire {

	public static void main(String[] args) {
		
      add();
	}
	/**
	 * 随机生成职位
	 * @return
	 */
	public static String getPosition() {
    	String[] position= {"销售经理","总监","Java工程师","前端设计师","前台","会计","主讲师","插画师","部门经理","主管","摄影师","室内设计师","平面设计师"};
    	int index=getNum(0, 12);
    	return position[index];
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
	  * 随机生成薪资
	  * @return
	  */
	public static String getSalary() {
		 StringBuilder in=new StringBuilder("薪资：");
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
	/**
	 * 随机生成企业地址
	 * @return
	 */
	 public static String getAddress() {
	    	String[] address= {"北京","上海","广州","天津","南京","长沙","深圳","汕头","吉林","杭州","东莞","厦门","武汉"};
	    	int index=getNum(0, 12);
	    	return address[index];
	    }
	 /**
	  * 将随机生成的招聘信息插入数据库中招聘信息表
	  */
	 public static void add() {//增加到数据库
	      	DataConnectionMysql dbcs=new DataConnectionMysql();//使用定义的连接数据库的类
	      	String sql="insert into 招聘信息(position,salary,company,address) values(?,?,?,?)";//使用占位符定义插入语句
	      	try(Connection conn=dbcs.getConnection();//获取数据库接
	      		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	      		for(int i=1;i<=9;) {
	      				String company=getName();//随机获取名字
	      				String position=getPosition();
	      				String salary=getSalary();
	      				String address=getAddress();
	      				pstmt.setString(1, position);//定义第1个占位符的内容
	      	    		pstmt.setString(2, salary);//定义第2个占位符的内容
	      	    		pstmt.setString(3,company);
	      	    		pstmt.setString(4, address);
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
