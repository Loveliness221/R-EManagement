package jsu.cmd.registe;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import jsu.cmd.information.PostRecruitment;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 初始化发布招聘窗口
 * @author Think
 *
 */
public class PublishWindow {
	private static JTextField textFieldZw;
	private static JTextField textFieldXz;
	private static JTextField textFieldQym;
	private static JTextField textFieldQydz;
public PublishWindow() {}
       public void publishWindow() {
		JFrame frame6=new JFrame("发布招聘");
		frame6.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\u6211\u7684\u56FE\u7247\\\u7F51\u7EDC\u7167\u7247\\7602\\r1.png"));
		frame6.getContentPane().setFont(new Font("宋体", Font.PLAIN, 18));
		frame6.getContentPane().setBackground(new Color(255, 218, 185));
		frame6.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u804C\u4F4D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(52, 64, 68, 36);
		frame6.getContentPane().add(lblNewLabel);
		
		textFieldZw = new JTextField();
		textFieldZw.setFont(new Font("宋体", Font.PLAIN, 18));
		textFieldZw.setBounds(134, 64, 178, 36);
		frame6.getContentPane().add(textFieldZw);
		textFieldZw.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u85AA\u8D44\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(52, 145, 72, 36);
		frame6.getContentPane().add(lblNewLabel_1);
		
		textFieldXz = new JTextField();
		textFieldXz.setFont(new Font("宋体", Font.PLAIN, 18));
		textFieldXz.setBounds(134, 145, 178, 36);
		frame6.getContentPane().add(textFieldXz);
		textFieldXz.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F01\u4E1A\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(52, 229, 72, 36);
		frame6.getContentPane().add(lblNewLabel_2);
		
		textFieldQym = new JTextField();
		textFieldQym.setFont(new Font("宋体", Font.PLAIN, 18));
		textFieldQym.setBounds(134, 229, 242, 36);
		frame6.getContentPane().add(textFieldQym);
		textFieldQym.setColumns(10);
		
		JLabel label = new JLabel("\u4F01\u4E1A\u5730\u5740\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(52, 321, 90, 36);
		frame6.getContentPane().add(label);
		
		textFieldQydz = new JTextField();
		textFieldQydz.setFont(new Font("宋体", Font.PLAIN, 18));
		textFieldQydz.setBounds(134, 321, 242, 37);
		frame6.getContentPane().add(textFieldQydz);
		textFieldQydz.setColumns(10);
		
		JButton button = new JButton("发布");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PostRecruitment p=new PostRecruitment();
				p.addCom(textFieldZw, textFieldXz, textFieldQym, textFieldQydz);//将招聘信息插入到招聘信息里
				JOptionPane.showMessageDialog(null, "发布成功！");
				frame6.setVisible(false);//发布窗体消失
			}
		});
		button.setBackground(new Color(64, 224, 208));
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(168, 418, 113, 27);
		frame6.getContentPane().add(button);
		frame6.setBackground(new Color(255, 218, 185));
		frame6.setSize(500,600);
		frame6.setLocationRelativeTo(null);
		frame6.setVisible(true);
		
	}
}
