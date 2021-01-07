package jsu.cmd.registe;

import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * 初始化登录界面
 * 有五个监听事件
 * 点击注册调用注册窗口初始化界面
 * 监听文本输入框与判断用户类型按钮
 * @author Think
 *
 */
public class LoginWindow extends JFrame{
	private static JTextField textFieldzh;
	private static JPasswordField passwordField;
    public LoginWindow() {
    	init();//初始化窗体登录界面
    }
	public void init() {
		JFrame frame=new JFrame();//登录窗体
		frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 18));
		frame.getContentPane().setBackground(new Color(255, 218, 185));
		frame.setBackground(new Color(255, 218, 185));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("DD招聘网");
		lblTitle.setFont(new Font("华文琥珀", Font.PLAIN, 35));
		lblTitle.setForeground(new Color(0, 206, 209));
		lblTitle.setBackground(new Color(255, 218, 185));
		lblTitle.setBounds(187, 13, 228, 90);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblZhanghao = new JLabel("账号:");
		lblZhanghao.setIcon(new ImageIcon("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7469\\q8.png"));
		lblZhanghao.setFont(new Font("宋体", Font.PLAIN, 18));
		lblZhanghao.setBounds(67, 115, 91, 38);
		frame.getContentPane().add(lblZhanghao);
		
		textFieldzh = new JTextField();
		textFieldzh.setFont(new Font("宋体", Font.PLAIN, 18));
		textFieldzh.setBounds(159, 116, 215, 37);
		frame.getContentPane().add(textFieldzh);
		textFieldzh.setColumns(10);
		
		JLabel labelPassword = new JLabel("密码:");
		labelPassword.setIcon(new ImageIcon("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7469\\q7.png"));
		labelPassword.setFont(new Font("宋体", Font.PLAIN, 18));
		labelPassword.setBounds(67, 194, 99, 38);
		frame.getContentPane().add(labelPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 194, 215, 38);
		frame.getContentPane().add(passwordField);
		
		JLabel lblMsgZh = new JLabel("");
		lblMsgZh.setForeground(Color.RED);
		lblMsgZh.setFont(new Font("宋体", Font.PLAIN, 18));
		lblMsgZh.setBounds(388, 116, 142, 37);
		frame.getContentPane().add(lblMsgZh);
		
		JLabel lblMsgMm = new JLabel("");
		lblMsgMm.setForeground(Color.RED);
		lblMsgMm.setFont(new Font("宋体", Font.PLAIN, 18));
		lblMsgMm.setBounds(388, 194, 142, 38);
		frame.getContentPane().add(lblMsgMm);
		frame.setForeground(new Color(0, 0, 0));
		
		JLabel lblremark=new JLabel("");
		JRadioButton radioButtongGr = new JRadioButton("个人");
		radioButtongGr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//监听按钮事件
				DetermineInput d=new DetermineInput();
				d.checkInputP(lblremark);
			}
		});
		radioButtongGr.setBackground(new Color(255, 218, 185));
		radioButtongGr.setFont(new Font("宋体", Font.PLAIN, 18));
		radioButtongGr.setBounds(159, 257, 99, 27);
		frame.getContentPane().add(radioButtongGr);
		
		JRadioButton radioButtonQy = new JRadioButton("企业");
		radioButtonQy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetermineInput D=new DetermineInput();
				D.checkInputC(lblremark);
			}
		});
		radioButtonQy.setBackground(new Color(255, 218, 185));
		radioButtonQy.setFont(new Font("宋体", Font.PLAIN, 18));
		radioButtonQy.setBounds(297, 257, 91, 27);
		frame.getContentPane().add(radioButtonQy);
		
		JLabel lblNewLabel = new JLabel("注册");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				RegisterWindow r=new RegisterWindow();
				r.intiRegister();//调用注册窗体
				frame.setVisible(false);
			}
		});
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(432, 347, 72, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButtonDl = new JButton("登录");
		btnNewButtonDl.addActionListener(new ActionListener() {//给按钮增加监听事件
			public void actionPerformed(ActionEvent arg0) {//监听账号密码输入框是否输入正确
				DetermineInput check=new DetermineInput();
				check.checkInputZh(textFieldzh, lblMsgZh);
				check.checkInputPass(passwordField, lblMsgMm);
				if(check.checkInputZh(textFieldzh, lblMsgZh)&&check.checkInputPass(passwordField, lblMsgMm))//如果账号和密码都不为空则判断是否存在与正确
				{
				try {
					check.checkInputRight(textFieldzh, passwordField, lblMsgZh, lblMsgMm,lblremark);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//分别判断账号密码是否正确且是个人还是企业，然后调用菜单窗体
					try {
						if(check.checkInputRight(textFieldzh, passwordField, lblMsgZh, lblMsgMm,lblremark)&lblremark.getText().equals("select * from 个人账户"))
						{
							 PerMenuWindow m=new PerMenuWindow();//调用子窗体
							  m.initPer();
							  PerCenterWindow p=new PerCenterWindow();
							  p.ac(textFieldzh);//记录账号
							  frame.setVisible(false);//父窗体消失
    }
					if(check.checkInputRight(textFieldzh, passwordField, lblMsgZh, lblMsgMm, lblremark)&lblremark.getText().equals("select * from 企业账户"))
					  {
						  ComMenuWindow m=new ComMenuWindow();//调用子窗体
						  m.initPer();
						  PerCenterWindow p=new PerCenterWindow();
						  p.ac(textFieldzh);//记录账号
						  frame.setVisible(false);//父窗体消失
    }
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButtonDl.setForeground(new Color(0, 0, 0));
		btnNewButtonDl.setBackground(new Color(0, 206, 209));
		btnNewButtonDl.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButtonDl.setBounds(187, 293, 134, 27);
		frame.getContentPane().add(btnNewButtonDl);
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7602\\r1.png"));//设置窗体标题图标
		frame.setTitle("DD招聘网");//设置窗体标题
		frame.setLocationRelativeTo(null);//设置窗体居中显示
		frame.setResizable(false);//设置登录窗口大小不可改变
		frame.setSize(550,450);
        frame.setVisible(true);//设置窗体可见
        
        
	}
}
