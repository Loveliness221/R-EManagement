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
 * ��ʼ����¼����
 * ����������¼�
 * ���ע�����ע�ᴰ�ڳ�ʼ������
 * �����ı���������ж��û����Ͱ�ť
 * @author Think
 *
 */
public class LoginWindow extends JFrame{
	private static JTextField textFieldzh;
	private static JPasswordField passwordField;
    public LoginWindow() {
    	init();//��ʼ�������¼����
    }
	public void init() {
		JFrame frame=new JFrame();//��¼����
		frame.getContentPane().setFont(new Font("����", Font.PLAIN, 18));
		frame.getContentPane().setBackground(new Color(255, 218, 185));
		frame.setBackground(new Color(255, 218, 185));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("DD��Ƹ��");
		lblTitle.setFont(new Font("��������", Font.PLAIN, 35));
		lblTitle.setForeground(new Color(0, 206, 209));
		lblTitle.setBackground(new Color(255, 218, 185));
		lblTitle.setBounds(187, 13, 228, 90);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblZhanghao = new JLabel("�˺�:");
		lblZhanghao.setIcon(new ImageIcon("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7469\\q8.png"));
		lblZhanghao.setFont(new Font("����", Font.PLAIN, 18));
		lblZhanghao.setBounds(67, 115, 91, 38);
		frame.getContentPane().add(lblZhanghao);
		
		textFieldzh = new JTextField();
		textFieldzh.setFont(new Font("����", Font.PLAIN, 18));
		textFieldzh.setBounds(159, 116, 215, 37);
		frame.getContentPane().add(textFieldzh);
		textFieldzh.setColumns(10);
		
		JLabel labelPassword = new JLabel("����:");
		labelPassword.setIcon(new ImageIcon("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7469\\q7.png"));
		labelPassword.setFont(new Font("����", Font.PLAIN, 18));
		labelPassword.setBounds(67, 194, 99, 38);
		frame.getContentPane().add(labelPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 194, 215, 38);
		frame.getContentPane().add(passwordField);
		
		JLabel lblMsgZh = new JLabel("");
		lblMsgZh.setForeground(Color.RED);
		lblMsgZh.setFont(new Font("����", Font.PLAIN, 18));
		lblMsgZh.setBounds(388, 116, 142, 37);
		frame.getContentPane().add(lblMsgZh);
		
		JLabel lblMsgMm = new JLabel("");
		lblMsgMm.setForeground(Color.RED);
		lblMsgMm.setFont(new Font("����", Font.PLAIN, 18));
		lblMsgMm.setBounds(388, 194, 142, 38);
		frame.getContentPane().add(lblMsgMm);
		frame.setForeground(new Color(0, 0, 0));
		
		JLabel lblremark=new JLabel("");
		JRadioButton radioButtongGr = new JRadioButton("����");
		radioButtongGr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//������ť�¼�
				DetermineInput d=new DetermineInput();
				d.checkInputP(lblremark);
			}
		});
		radioButtongGr.setBackground(new Color(255, 218, 185));
		radioButtongGr.setFont(new Font("����", Font.PLAIN, 18));
		radioButtongGr.setBounds(159, 257, 99, 27);
		frame.getContentPane().add(radioButtongGr);
		
		JRadioButton radioButtonQy = new JRadioButton("��ҵ");
		radioButtonQy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetermineInput D=new DetermineInput();
				D.checkInputC(lblremark);
			}
		});
		radioButtonQy.setBackground(new Color(255, 218, 185));
		radioButtonQy.setFont(new Font("����", Font.PLAIN, 18));
		radioButtonQy.setBounds(297, 257, 91, 27);
		frame.getContentPane().add(radioButtonQy);
		
		JLabel lblNewLabel = new JLabel("ע��");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				RegisterWindow r=new RegisterWindow();
				r.intiRegister();//����ע�ᴰ��
				frame.setVisible(false);
			}
		});
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel.setBounds(432, 347, 72, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButtonDl = new JButton("��¼");
		btnNewButtonDl.addActionListener(new ActionListener() {//����ť���Ӽ����¼�
			public void actionPerformed(ActionEvent arg0) {//�����˺�����������Ƿ�������ȷ
				DetermineInput check=new DetermineInput();
				check.checkInputZh(textFieldzh, lblMsgZh);
				check.checkInputPass(passwordField, lblMsgMm);
				if(check.checkInputZh(textFieldzh, lblMsgZh)&&check.checkInputPass(passwordField, lblMsgMm))//����˺ź����붼��Ϊ�����ж��Ƿ��������ȷ
				{
				try {
					check.checkInputRight(textFieldzh, passwordField, lblMsgZh, lblMsgMm,lblremark);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//�ֱ��ж��˺������Ƿ���ȷ���Ǹ��˻�����ҵ��Ȼ����ò˵�����
					try {
						if(check.checkInputRight(textFieldzh, passwordField, lblMsgZh, lblMsgMm,lblremark)&lblremark.getText().equals("select * from �����˻�"))
						{
							 PerMenuWindow m=new PerMenuWindow();//�����Ӵ���
							  m.initPer();
							  PerCenterWindow p=new PerCenterWindow();
							  p.ac(textFieldzh);//��¼�˺�
							  frame.setVisible(false);//��������ʧ
    }
					if(check.checkInputRight(textFieldzh, passwordField, lblMsgZh, lblMsgMm, lblremark)&lblremark.getText().equals("select * from ��ҵ�˻�"))
					  {
						  ComMenuWindow m=new ComMenuWindow();//�����Ӵ���
						  m.initPer();
						  PerCenterWindow p=new PerCenterWindow();
						  p.ac(textFieldzh);//��¼�˺�
						  frame.setVisible(false);//��������ʧ
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
		btnNewButtonDl.setFont(new Font("����", Font.PLAIN, 18));
		btnNewButtonDl.setBounds(187, 293, 134, 27);
		frame.getContentPane().add(btnNewButtonDl);
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7602\\r1.png"));//���ô������ͼ��
		frame.setTitle("DD��Ƹ��");//���ô������
		frame.setLocationRelativeTo(null);//���ô��������ʾ
		frame.setResizable(false);//���õ�¼���ڴ�С���ɸı�
		frame.setSize(550,450);
        frame.setVisible(true);//���ô���ɼ�
        
        
	}
}
