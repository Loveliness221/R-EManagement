package jsu.cmd.search;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import jsu.cmd.connection.DataConnectionMysql;
/**
 * ������Ƹ����ְ��Ϣ
 * @author Think
 *
 */
public class JobSearch {
	/**
	 * ������Ƹ��Ϣ
	 * �����ݿ���Ƹ��Ϣ���а����ֶ�ģ����ѯ�û�������Ϣ
	 * @param textArea
	 * @param textField
	 */
    public void searchJob(JTextArea textArea,JTextField textField)
    {
    	String x="";
    	DataConnectionMysql dbcs=new DataConnectionMysql();
    	Connection conn=dbcs.getConnection();
    	String sql;
    	String s="position like '"+textField.getText()+"%' or salary like '%"+textField.getText()+"%'or company like '"+textField.getText()+"%'or address like '"+textField.getText()+"%'";
    	sql="select * from ��Ƹ��Ϣ where ";
    	sql+=s;
    	try{PreparedStatement pstmt=conn.prepareStatement(sql);//ʵ����PreparedStatement
    	ResultSet rs=pstmt.executeQuery();
    	while(rs.next())
    	{
    	x=x+rs.getString("position")+"\n";
    	x=x+rs.getString("salary")+"\n";
    	x=x+rs.getString("company")+"\n";
    	x=x+rs.getString("address")+"\n\n";
    	textArea.setText(x);//�����ı���Ϊ��������
    	}
    	
    	}catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }	
    /**
     * ������ְ��Ϣ
     * �����ݿ�����ְ��Ϣ�ı��а����ֶ�ģ����ѯ�û�������Ϣ
     * @param textArea
     * @param textField
     */
    public void searchEmploy(JTextArea textArea,JTextField textField)
    {
    	String x="";
    	DataConnectionMysql dbcs=new DataConnectionMysql();
    	Connection conn=dbcs.getConnection();
    	String sql;
    	String s="name like '"+textField.getText()+"%' or sex like '"+textField.getText()+"%' or age like '"+textField.getText()+"%' or education like '"+textField.getText()+"%' or major like '"+textField.getText()+"%' or salary like '"+textField.getText()+"%' or experience like '"+textField.getText()+"%'";
    	sql="select * from ��ְ��Ϣ where ";
    	sql+=s;
    	try{PreparedStatement pstmt=conn.prepareStatement(sql);//ʵ����PreparedStatement
    	ResultSet rs=pstmt.executeQuery();
    	while(rs.next())
    	{
    	x=x+rs.getString("name")+"  ";
    	x=x+rs.getString("sex")+"  ";
    	x=x+rs.getString("age")+"\n";
    	x=x+rs.getString("education")+"\n";
    	x=x+rs.getString("major")+"רҵ\n�绰���룺";
    	x=x+rs.getString("number")+"\n�������飺";
    	x=x+rs.getString("experience")+"\n";
    	x=x+rs.getString("salary")+"\n\n";
    	textArea.setText(x);//�����ı���Ϊ��������
    	}
    	
    	}catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }	
    }