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
 * ��ʼ�������˻��Ӵ���
 * ���ĸ������¼�
 * �ɷ����������鿴�������ģ��Լ�������Ƹ��Ϣ
 * @author Think
 *
 */
public class PerMenuWindow extends JFrame {
	private  JTextField textField;
	public PerMenuWindow() {}
		public void initPer()//��ʼ�������˻��Ӵ���
	{
		JFrame frame1=new JFrame("");
		frame1.setBackground(new Color(255, 255, 255));
		frame1.setForeground(new Color(0, 0, 0));
		frame1.getContentPane().setBackground(new Color(255, 218, 185));
		frame1.getContentPane().setFont(new Font("��������", Font.PLAIN, 18));
		frame1.getContentPane().setLayout(null);//���Զ�λ
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setFont(new Font("����", Font.PLAIN, 18));
		textField.setBounds(157, 58, 235, 34);
		frame1.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("����", Font.PLAIN, 18));
		textArea.setBounds(43, 157, 500, 500);
		GetJobInfor g=new GetJobInfor();
		g.getInfo(textArea);
		textArea.setEditable(false);//���ò��ɱ༭
		
		JButton btnButtonSearch = new JButton("����");
		btnButtonSearch.setForeground(new Color(0, 0, 0));
		btnButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JobSearch j=new JobSearch();
				j.searchJob(textArea, textField);
			}
		});
		btnButtonSearch.setFont(new Font("����", Font.PLAIN, 18));
		btnButtonSearch.setBackground(new Color(0, 206, 209));
		btnButtonSearch.setBounds(396, 57, 102, 34);
		frame1.getContentPane().add(btnButtonSearch);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7469\\q9.png"));
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(512, 28, 50, 50);
		frame1.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPerCenter = new JLabel("��������");
		lblPerCenter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
					PerCenterWindow p=new PerCenterWindow();
					p.initCenter();
				
			}
		});
		lblPerCenter.setFont(new Font("����", Font.PLAIN, 18));
		lblPerCenter.setBounds(503, 80, 72, 18);
		frame1.getContentPane().add(lblPerCenter);
		
		JLabel label = new JLabel("\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(45, 105, 498, 18);
		frame1.getContentPane().add(label);
		
		JLabel lblNewLabel_3 = new JLabel("��˾ӦƸ");
		lblNewLabel_3.setForeground(new Color(0, 206, 209));
		lblNewLabel_3.setFont(new Font("��������", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(80, 124, 72, 18);
		frame1.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ʵϰ��λ");
		lblNewLabel_4.setFont(new Font("��������", Font.PLAIN, 18));
		lblNewLabel_4.setForeground(new Color(0, 206, 209));
		lblNewLabel_4.setBounds(232, 124, 72, 18);
		frame1.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("��н��ְ");
		lblNewLabel_5.setForeground(new Color(0, 206, 209));
		lblNewLabel_5.setFont(new Font("��������", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(374, 124, 72, 18);
		frame1.getContentPane().add(lblNewLabel_5);
		
		JButton btnButtonSub = new JButton("��������");
		btnButtonSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubmitWindow s=new SubmitWindow();//���÷�����������
				s.intiSub();
			}
		});
		btnButtonSub.setBackground(new Color(64, 224, 208));
		btnButtonSub.setFont(new Font("����", Font.PLAIN, 18));
		btnButtonSub.setBounds(35, 58, 108, 34);
		frame1.getContentPane().add(btnButtonSub);
		//GetJobInfor g=new GetJobInfor();
		
		/*JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("����", Font.PLAIN, 18));
		textArea.setBounds(43, 157, 500, 500);
		g.getInfo(textArea);
		textArea.setEditable(false);//���ò��ɱ༭*/
		
		
		JScrollPane scrollPane = new JScrollPane(textArea);// ����������壬��ӹ�����
		scrollPane.setBounds(43, 157, 500, 400);// ���ô�С��λ��
		frame1.getContentPane().add(scrollPane);// �����������뵽���������
		
		
		frame1.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7602\\r1.png"));
		frame1.setTitle("DD��Ƹ��");
		frame1.setSize(600,620);
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
	}
}
