package jsu.cmd.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * 随机生成个人简历信息
 * @author Think
 *
 */
public class PerResume {

	public static void main(String[] args) {	
     add();
	}
	public static int getNum(int start,int end) {//随机返回指定范围间的整数
        return (int)(Math.random()*(end-start+1)+start);
    }
	/**
	 * 随机生成姓名
	 * @return
	 */
	public static String getName() {
		String firstName="赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
		//定义女生的名
		String girl="秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
		//定义男生的名
	    String boy="伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
	        int index=getNum(0, firstName.length()-1);//随机取姓氏字符串中的任意位置
	        String first=firstName.substring(index, index+1);//获取该位置的姓氏
	        int sex=getNum(0,1);//随机取性别，例如1为男生，0为女生
	        String str=boy;//定义名字为男生字符串
	        int length=boy.length();//获取男生字符串的长度
	        if(sex==0){//如果随机获取为0，则名字改为女生
	            str=girl;
	            length=girl.length();
	        }
	        index=getNum(0,length-1);//随机获取名字的位置
	        String second=str.substring(index, index+1);//获取该位置中的名字
	        int hasThird=getNum(0,1);//随机获取名字是否有第三个字
	        String third="";//默认没有第三个字
	        if(hasThird==1){//如果随机获取为1，则有第三个字
	            index=getNum(0,length-1);
	            third=str.substring(index, index+1);
	        }
	        return first+second+third;//返回姓名
	    }
    /**
     * 随机获得性别
     * @return
     */
    public static String getSex(){
    	int sex=getNum(0,1);
    	if(sex==0)
    	{
    		return "女";
    	}
    	else return "男";
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
     * 随机获取电话号码
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
   * 随机返回学历
   */
  public static String getEducation() {
	  int flag=getNum(0, 3);
	  if(flag==0)
		  return"专科";
	  else if(flag==1)
		  return "本科";
	  else if(flag==2)
		  return "研究生";
	  else return "博士";
  }
  /**
   * 随机返回个人说明
   * @return
   */
  public static String getIntroduce() {
	 StringBuilder in=new StringBuilder("预期薪资：");
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
   * 将随机生成的个人简历信息插入到个人简历信息系表
   */
  public static void add() {//增加到数据库
  	DataConnectionMysql dbcs=new DataConnectionMysql();//使用定义的连接数据库的类
  	String sql="insert into 个人简历信息(name,sex,age,account,number,education,introduce) values(?,?,?,?,?,?,?)";//使用占位符定义插入语句
  	try(Connection conn=dbcs.getConnection();//获取数据库接
  		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
      	ArrayList<String> alist=new ArrayList<String>();//定义集合
  		for(int i=1;i<=1;) {
  				String name=getName();//随机获取名字
  				String sex=getSex();
  				int age=getNum(20,45);
  				String account=getAccount().toString();
  				String number=getNumber().toString();
  				String education=getEducation();
  				String introduce=getIntroduce();
  				pstmt.setString(1, name);//定义第1个占位符的内容
  	    		pstmt.setString(2, sex);//定义第2个占位符的内容
  	    		pstmt.setInt(3, age);
  	    		pstmt.setString(4, account);
  	    		pstmt.setString(5, number);//定义第4个占位符的内容
  	    		pstmt.setString(6,education);
  	    		pstmt.setString(7,introduce);
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
