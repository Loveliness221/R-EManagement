package jsu.cmd.registe;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import jsu.cmd.information.InsertPer;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
/**
 * ��ʼ��ע�ᴰ��
 * ע��ɹ���ʾ
 * @author Think
 *
 */
public class RegisterWindow extends JFrame {
	private JTextField textFieldNc;
	private JTextField textFieldMm;

	public RegisterWindow() {}
public void intiRegister() //��ʼ��ע�ᴰ��
	{
		JFrame frame3=new JFrame("ע��");
		frame3.setSize(473,395);
		frame3.setLocationRelativeTo(null);
		
		frame3.getContentPane().setBackground(new Color(255, 218, 185));
		frame3.getContentPane().setLayout(null);
		
		JLabel labelNc = new JLabel("����:");
		labelNc.setFont(new Font("����", Font.PLAIN, 18));
		labelNc.setBounds(48, 40, 72, 36);
		frame3.getContentPane().add(labelNc);
		
		JLabel labelMm = new JLabel("����:");
		labelMm.setFont(new Font("����", Font.PLAIN, 18));
		labelMm.setBounds(48, 130, 72, 36);
		frame3.getContentPane().add(labelMm);
		
		JLabel lblaccount=new JLabel();
		textFieldNc = new JTextField();
		textFieldNc.setFont(new Font("����", Font.PLAIN, 18));
		textFieldNc.setBounds(110, 40, 256, 36);
		frame3.getContentPane().add(textFieldNc);
		textFieldNc.setColumns(10);
		
		textFieldMm = new JTextField();
		textFieldMm.setFont(new Font("����", Font.PLAIN, 18));
		textFieldMm.setBounds(110, 130, 256, 36);
		frame3.getContentPane().add(textFieldMm);
		textFieldMm.setColumns(10);
		
		JLabel remark1=new JLabel();
		JLabel remark2=new JLabel();
		JRadioButton radioButtonPer = new JRadioButton("����");
		radioButtonPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertPer P=new InsertPer();
				P.checkInputP(remark1,remark2);
			}
		});
		radioButtonPer.setFont(new Font("����", Font.PLAIN, 18));
		radioButtonPer.setBackground(new Color(255, 218, 185));
		radioButtonPer.setBounds(110, 211, 92, 27);
		frame3.getContentPane().add(radioButtonPer);
		
		JRadioButton radioButtonCom = new JRadioButton("��ҵ");
		radioButtonCom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertPer C=new InsertPer();
				C.checkInputC(remark1,remark2);
			}
		});
		radioButtonCom.setBackground(new Color(255, 218, 185));
		radioButtonCom.setFont(new Font("����", Font.PLAIN, 18));
		radioButtonCom.setBounds(267, 213, 92, 27);
		frame3.getContentPane().add(radioButtonCom);
		
		JButton buttonZc = new JButton("ע��");
		buttonZc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertPer IP=new InsertPer();
				try {
					IP.addResume(textFieldNc, lblaccount, remark1);
					IP.addAccountPass(lblaccount, textFieldMm,remark2);//��������뵽�˻���Ϣ
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "ע��ɹ�������˺�Ϊ"+lblaccount.getText());
				frame3.setVisible(false);//ע�ᴰ����ʧ
			}
		});
		buttonZc.setFont(new Font("����", Font.PLAIN, 18));
		buttonZc.setBackground(new Color(64, 224, 208));
		buttonZc.setBounds(159, 247, 113, 27);
		frame3.getContentPane().add(buttonZc);
		frame3.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7602\\r1.png"));
	
	frame3.setVisible(true);
	}
	
}

