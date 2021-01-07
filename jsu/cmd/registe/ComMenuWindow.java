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
 * ��ʼ����ҵ�˻��Ӵ���
 * @author Think
 *
 */
public class ComMenuWindow extends JFrame{
	private  JTextField textField;
	public ComMenuWindow() {}
		public void initPer()//��ʼ����ҵ�˻��Ӵ���
	{
		JFrame frame2=new JFrame("");
		frame2.setBackground(new Color(255, 255, 255));
		frame2.setForeground(new Color(0, 0, 0));
		frame2.getContentPane().setBackground(new Color(255, 218, 185));
		frame2.getContentPane().setFont(new Font("��������", Font.PLAIN, 18));
		frame2.getContentPane().setLayout(null);//���Զ�λ
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setFont(new Font("����", Font.PLAIN, 18));
		textField.setBounds(157, 58, 235, 34);
		frame2.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("����", Font.PLAIN, 18));
		textArea.setBounds(43, 157, 500, 500);
		GetEmployInfo e=new GetEmployInfo();
		e.getInfo(textArea);//�õ���ְ����Ϣ
		//textArea.setEditable(false);//���ò��ɱ༭
		
		JButton btnButtonSearch = new JButton("����");
		btnButtonSearch.setForeground(new Color(0, 0, 0));
		btnButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JobSearch j=new JobSearch();
				j.searchEmploy(textArea, textField);
			}
		});
		btnButtonSearch.setFont(new Font("����", Font.PLAIN, 18));
		btnButtonSearch.setBackground(new Color(0, 206, 209));
		btnButtonSearch.setBounds(396, 57, 102, 34);
		frame2.getContentPane().add(btnButtonSearch);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7469\\q9.png"));
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(512, 28, 50, 50);
		frame2.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPerCenter = new JLabel("��������");
		lblPerCenter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
					ComCenterWindow c=new ComCenterWindow();
				c.initCom();//���ò鿴����������Ϣ
			}
		});
		lblPerCenter.setFont(new Font("����", Font.PLAIN, 18));
		lblPerCenter.setBounds(503, 80, 72, 18);
		frame2.getContentPane().add(lblPerCenter);
		
		JLabel label = new JLabel("\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(35, 105, 473, 18);
		frame2.getContentPane().add(label);
		
		JButton btnButtonSub = new JButton("������Ƹ");
		btnButtonSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PublishWindow p=new PublishWindow();
				p.publishWindow();//������д��Ƹ��Ϣ��
				}
		});
		btnButtonSub.setBackground(new Color(64, 224, 208));
		btnButtonSub.setFont(new Font("����", Font.PLAIN, 18));
		btnButtonSub.setBounds(35, 58, 108, 34);
		frame2.getContentPane().add(btnButtonSub);
		
		/*JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("����", Font.PLAIN, 18));
		textArea.setBounds(43, 157, 500, 500);
		GetEmployInfo e=new GetEmployInfo();
		e.getInfo(textArea);//�õ���ְ����Ϣ
		textArea.setEditable(false);//���ò��ɱ༭*/
		
		
		JScrollPane scrollPane = new JScrollPane(textArea);// ����������壬��ӹ�����
		scrollPane.setBounds(45, 136, 500, 400);// ���ô�С��λ��
		frame2.getContentPane().add(scrollPane);// �����������뵽���������
		
		
		frame2.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7602\\r1.png"));
		frame2.setTitle("DD��Ƹ��");
		frame2.setSize(600,620);
		frame2.setLocationRelativeTo(null);
		frame2.setVisible(true);
	}
}

