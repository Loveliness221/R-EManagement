package jsu.cmd.operation;

import jsu.cmd.registe.ComMenuWindow;
import jsu.cmd.registe.LoginWindow;
import jsu.cmd.registe.PerMenuWindow;
import jsu.cmd.registe.PublishWindow;
import jsu.cmd.registe.PerCenterWindow;
import jsu.cmd.registe.RegisterWindow;
import jsu.cmd.registe.SubmitWindow;

public class Operation {

	public static void main(String[] args) {
		LoginWindow login=new LoginWindow();//调用初始化登录界面
		PerMenuWindow m=new PerMenuWindow();
		RegisterWindow r=new RegisterWindow();
		PerCenterWindow p=new PerCenterWindow();
		SubmitWindow s=new SubmitWindow();
		ComMenuWindow c=new ComMenuWindow();
		PublishWindow ps=new PublishWindow();
		ComMenuWindow cm=new ComMenuWindow();

	}

}
