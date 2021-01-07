package jsu.cmd.registe;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import jsu.cmd.information.GetJobInfor;
import jsu.cmd.search.JobSearch;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JTextArea;
/**
 * 初始化个人账户子窗体
 * 有四个监听事件
 * 可发布简历，查看个人中心，以及搜索招聘信息
 * @author Think
 *
 */
public class PerMenuWindow extends JFrame {
	private  JTextField textField;
	public PerMenuWindow() {}
		public void initPer()//初始化个人账户子窗体
	{
		JFrame frame1=new JFrame("");
		frame1.setBackground(new Color(255, 255, 255));
		frame1.setForeground(new Color(0, 0, 0));
		frame1.getContentPane().setBackground(new Color(255, 218, 185));
		frame1.getContentPane().setFont(new Font("华文琥珀", Font.PLAIN, 18));
		frame1.getContentPane().setLayout(null);//绝对定位
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setBounds(157, 58, 235, 34);
		frame1.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("宋体", Font.PLAIN, 18));
		textArea.setBounds(43, 157, 500, 500);
		GetJobInfor g=new GetJobInfor();
		g.getInfo(textArea);
		textArea.setEditable(false);//设置不可编辑
		
		JButton btnButtonSearch = new JButton("搜索");
		btnButtonSearch.setForeground(new Color(0, 0, 0));
		btnButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JobSearch j=new JobSearch();
				j.searchJob(textArea, textField);
			}
		});
		btnButtonSearch.setFont(new Font("宋体", Font.PLAIN, 18));
		btnButtonSearch.setBackground(new Color(0, 206, 209));
		btnButtonSearch.setBounds(396, 57, 102, 34);
		frame1.getContentPane().add(btnButtonSearch);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7469\\q9.png"));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(512, 28, 50, 50);
		frame1.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPerCenter = new JLabel("个人中心");
		lblPerCenter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
					PerCenterWindow p=new PerCenterWindow();
					p.initCenter();
				
			}
		});
		lblPerCenter.setFont(new Font("宋体", Font.PLAIN, 18));
		lblPerCenter.setBounds(503, 80, 72, 18);
		frame1.getContentPane().add(lblPerCenter);
		
		JLabel label = new JLabel("\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(45, 105, 498, 18);
		frame1.getContentPane().add(label);
		
		JLabel lblNewLabel_3 = new JLabel("公司应聘");
		lblNewLabel_3.setForeground(new Color(0, 206, 209));
		lblNewLabel_3.setFont(new Font("华文琥珀", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(80, 124, 72, 18);
		frame1.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("实习岗位");
		lblNewLabel_4.setFont(new Font("华文琥珀", Font.PLAIN, 18));
		lblNewLabel_4.setForeground(new Color(0, 206, 209));
		lblNewLabel_4.setBounds(232, 124, 72, 18);
		frame1.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("高薪兼职");
		lblNewLabel_5.setForeground(new Color(0, 206, 209));
		lblNewLabel_5.setFont(new Font("华文琥珀", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(374, 124, 72, 18);
		frame1.getContentPane().add(lblNewLabel_5);
		
		JButton btnButtonSub = new JButton("发布简历");
		btnButtonSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubmitWindow s=new SubmitWindow();//调用发布简历窗口
				s.intiSub();
			}
		});
		btnButtonSub.setBackground(new Color(64, 224, 208));
		btnButtonSub.setFont(new Font("宋体", Font.PLAIN, 18));
		btnButtonSub.setBounds(35, 58, 108, 34);
		frame1.getContentPane().add(btnButtonSub);
		//GetJobInfor g=new GetJobInfor();
		
		/*JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("宋体", Font.PLAIN, 18));
		textArea.setBounds(43, 157, 500, 500);
		g.getInfo(textArea);
		textArea.setEditable(false);//设置不可编辑*/
		
		
		JScrollPane scrollPane = new JScrollPane(textArea);// 创建滚动面板，添加滚动条
		scrollPane.setBounds(43, 157, 500, 400);// 设置大小与位置
		frame1.getContentPane().add(scrollPane);// 将滚动面板加入到内容面板中
		
		
		frame1.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7602\\r1.png"));
		frame1.setTitle("DD招聘网");
		frame1.setSize(600,620);
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
	}
}
