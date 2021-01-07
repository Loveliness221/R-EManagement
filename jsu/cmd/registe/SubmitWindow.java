package jsu.cmd.registe;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import jsu.cmd.information.ReleaResume;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 初始化发布简历窗口
 * @author Think
 *
 */
public class SubmitWindow extends JFrame{
	private JTextField textFieldXm;
	private JTextField textFieldNl;
	private JTextField textFieldMajor;
	private JTextField textFieldEducation;
	private JTextField textFieldNumber;
	private JTextField textFieldSalary;
	private JTextField textFieldExperience;
        public SubmitWindow() {
        	
        }
        public void intiSub() {
        	JFrame frame5=new JFrame("发布简历");
        	frame5.setSize(484,722);
        	frame5.getContentPane().setFont(new Font("宋体", Font.PLAIN, 18));
        	frame5.getContentPane().setBackground(new Color(255, 218, 185));
        	frame5.getContentPane().setLayout(null);
        	
        	JLabel labelXm = new JLabel("\u59D3\u540D\uFF1A");
        	labelXm.setFont(new Font("宋体", Font.PLAIN, 18));
        	labelXm.setBounds(40, 36, 63, 33);
        	frame5.getContentPane().add(labelXm);
        	
        	textFieldXm = new JTextField();
        	textFieldXm.setFont(new Font("宋体", Font.PLAIN, 18));
        	textFieldXm.setBounds(106, 38, 172, 33);
        	frame5.getContentPane().add(textFieldXm);
        	textFieldXm.setColumns(10);
        	
        	JLabel lblXb = new JLabel("\u6027\u522B\uFF1A");
        	lblXb.setFont(new Font("宋体", Font.PLAIN, 18));
        	lblXb.setBounds(40, 106, 72, 33);
        	frame5.getContentPane().add(lblXb);
        	
        	JLabel labelNl = new JLabel("\u5E74\u9F84\uFF1A");
        	labelNl.setFont(new Font("宋体", Font.PLAIN, 18));
        	labelNl.setBounds(40, 173, 63, 33);
        	frame5.getContentPane().add(labelNl);
        	
        	textFieldNl = new JTextField();
        	textFieldNl.setFont(new Font("宋体", Font.PLAIN, 18));
        	textFieldNl.setBounds(106, 173, 172, 33);
        	frame5.getContentPane().add(textFieldNl);
        	textFieldNl.setColumns(10);
        	
        	JRadioButton radioButtonMan = new JRadioButton("男");
        	radioButtonMan.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			ReleaResume r=new ReleaResume();
        			r.CheckMan();
        		}
        	});
        	radioButtonMan.setBackground(new Color(255, 218, 185));
        	radioButtonMan.setFont(new Font("宋体", Font.PLAIN, 18));
        	radioButtonMan.setBounds(106, 111, 81, 27);
        	frame5.getContentPane().add(radioButtonMan);
        	
        	JRadioButton radioButtonWoman = new JRadioButton("女");
        	radioButtonWoman.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			ReleaResume r=new ReleaResume();
        			r.CheckWoman();
        		}
        	});
        	radioButtonWoman.setBackground(new Color(255, 218, 185));
        	radioButtonWoman.setFont(new Font("宋体", Font.PLAIN, 18));
        	radioButtonWoman.setBounds(198, 111, 81, 27);
        	frame5.getContentPane().add(radioButtonWoman);
        	
        	JLabel lblMajor = new JLabel("\u4E13\u4E1A\uFF1A");
        	lblMajor.setFont(new Font("宋体", Font.PLAIN, 18));
        	lblMajor.setBounds(40, 252, 63, 33);
        	frame5.getContentPane().add(lblMajor);
        	
        	textFieldMajor = new JTextField();
        	textFieldMajor.setFont(new Font("宋体", Font.PLAIN, 18));
        	textFieldMajor.setBounds(106, 252, 172, 33);
        	frame5.getContentPane().add(textFieldMajor);
        	textFieldMajor.setColumns(10);
        	
        	JLabel lblNewEducation = new JLabel("\u6559\u80B2\u7ECF\u5386\uFF1A");
        	lblNewEducation.setFont(new Font("宋体", Font.PLAIN, 18));
        	lblNewEducation.setBounds(40, 330, 90, 33);
        	frame5.getContentPane().add(lblNewEducation);
        	
        	textFieldEducation = new JTextField();
        	textFieldEducation.setFont(new Font("宋体", Font.PLAIN, 18));
        	textFieldEducation.setBounds(144, 332, 196, 33);
        	frame5.getContentPane().add(textFieldEducation);
        	textFieldEducation.setColumns(10);
        	
        	JLabel labelNumber = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
        	labelNumber.setFont(new Font("宋体", Font.PLAIN, 18));
        	labelNumber.setBounds(40, 411, 90, 33);
        	frame5.getContentPane().add(labelNumber);
        	
        	textFieldNumber = new JTextField();
        	textFieldNumber.setFont(new Font("宋体", Font.PLAIN, 18));
        	textFieldNumber.setBounds(145, 413, 195, 33);
        	frame5.getContentPane().add(textFieldNumber);
        	textFieldNumber.setColumns(10);
        	
        	JLabel lblNewLabelSalary = new JLabel("\u671F\u671B\u85AA\u8D44\uFF1A");
        	lblNewLabelSalary.setFont(new Font("宋体", Font.PLAIN, 18));
        	lblNewLabelSalary.setBounds(40, 481, 90, 33);
        	frame5.getContentPane().add(lblNewLabelSalary);
        	
        	textFieldSalary = new JTextField();
        	textFieldSalary.setFont(new Font("宋体", Font.PLAIN, 18));
        	textFieldSalary.setBounds(145, 483, 195, 33);
        	frame5.getContentPane().add(textFieldSalary);
        	textFieldSalary.setColumns(10);
        	
        	JLabel labelExperience = new JLabel("\u5DE5\u4F5C\u7ECF\u9A8C\uFF1A");
        	labelExperience.setFont(new Font("宋体", Font.PLAIN, 18));
        	labelExperience.setBounds(40, 552, 90, 33);
        	frame5.getContentPane().add(labelExperience);
        	
        	textFieldExperience = new JTextField();
        	textFieldExperience.setFont(new Font("宋体", Font.PLAIN, 18));
        	textFieldExperience.setBounds(145, 554, 195, 33);
        	frame5.getContentPane().add(textFieldExperience);
        	textFieldExperience.setColumns(10);
        	
        	JButton btnButtonSubmit = new JButton("提交");
        	btnButtonSubmit.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			ReleaResume r=new ReleaResume();
        			r.addPer(textFieldXm, textFieldNl, textFieldMajor, textFieldEducation, textFieldNumber, textFieldSalary,textFieldExperience);//提交即将信息插入到数据库
        			JOptionPane.showMessageDialog(null, "提交成功！");
    				frame5.setVisible(false);//提交窗体消失
        		}
        	});
        	btnButtonSubmit.setBackground(new Color(64, 224, 208));
        	btnButtonSubmit.setFont(new Font("宋体", Font.PLAIN, 18));
        	btnButtonSubmit.setBounds(165, 623, 113, 27);
        	frame5.getContentPane().add(btnButtonSubmit);
        	setBackground(new Color(255, 218, 185));
        	
        	frame5.setLocationRelativeTo(null);
        	frame5.setVisible(true);
        }
}
