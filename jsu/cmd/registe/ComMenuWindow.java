package jsu.cmd.registe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jsu.cmd.information.GetEmployInfo;
import jsu.cmd.information.GetJobInfor;
import jsu.cmd.search.JobSearch;
/**
 * 初始化企业账户子窗体
 * @author Think
 *
 */
public class ComMenuWindow extends JFrame{
	private  JTextField textField;
	public ComMenuWindow() {}
		public void initPer()//初始化企业账户子窗体
	{
		JFrame frame2=new JFrame("");
		frame2.setBackground(new Color(255, 255, 255));
		frame2.setForeground(new Color(0, 0, 0));
		frame2.getContentPane().setBackground(new Color(255, 218, 185));
		frame2.getContentPane().setFont(new Font("华文琥珀", Font.PLAIN, 18));
		frame2.getContentPane().setLayout(null);//绝对定位
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setBounds(157, 58, 235, 34);
		frame2.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("宋体", Font.PLAIN, 18));
		textArea.setBounds(43, 157, 500, 500);
		GetEmployInfo e=new GetEmployInfo();
		e.getInfo(textArea);//得到求职者信息
		//textArea.setEditable(false);//设置不可编辑
		
		JButton btnButtonSearch = new JButton("搜索");
		btnButtonSearch.setForeground(new Color(0, 0, 0));
		btnButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JobSearch j=new JobSearch();
				j.searchEmploy(textArea, textField);
			}
		});
		btnButtonSearch.setFont(new Font("宋体", Font.PLAIN, 18));
		btnButtonSearch.setBackground(new Color(0, 206, 209));
		btnButtonSearch.setBounds(396, 57, 102, 34);
		frame2.getContentPane().add(btnButtonSearch);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7469\\q9.png"));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(512, 28, 50, 50);
		frame2.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPerCenter = new JLabel("个人中心");
		lblPerCenter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
					ComCenterWindow c=new ComCenterWindow();
				c.initCom();//调用查看个人中心信息
			}
		});
		lblPerCenter.setFont(new Font("宋体", Font.PLAIN, 18));
		lblPerCenter.setBounds(503, 80, 72, 18);
		frame2.getContentPane().add(lblPerCenter);
		
		JLabel label = new JLabel("\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(35, 105, 473, 18);
		frame2.getContentPane().add(label);
		
		JButton btnButtonSub = new JButton("发布招聘");
		btnButtonSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PublishWindow p=new PublishWindow();
				p.publishWindow();//调用填写招聘信息表
				}
		});
		btnButtonSub.setBackground(new Color(64, 224, 208));
		btnButtonSub.setFont(new Font("宋体", Font.PLAIN, 18));
		btnButtonSub.setBounds(35, 58, 108, 34);
		frame2.getContentPane().add(btnButtonSub);
		
		/*JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("宋体", Font.PLAIN, 18));
		textArea.setBounds(43, 157, 500, 500);
		GetEmployInfo e=new GetEmployInfo();
		e.getInfo(textArea);//得到求职者信息
		textArea.setEditable(false);//设置不可编辑*/
		
		
		JScrollPane scrollPane = new JScrollPane(textArea);// 创建滚动面板，添加滚动条
		scrollPane.setBounds(45, 136, 500, 400);// 设置大小与位置
		frame2.getContentPane().add(scrollPane);// 将滚动面板加入到内容面板中
		
		
		frame2.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7602\\r1.png"));
		frame2.setTitle("DD招聘网");
		frame2.setSize(600,620);
		frame2.setLocationRelativeTo(null);
		frame2.setVisible(true);
	}
}

