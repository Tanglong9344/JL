package java_GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JTextFieldTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("文本框");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new FlowLayout());

		JLabel lName = new JLabel("账号：");
		// 输入框
		//JTextField tfName = new JTextField("请输入账号");
		JTextField tfName = new JTextField("");
		tfName.setText("请输入账号");
		tfName.setPreferredSize(new Dimension(80, 30));

		JLabel lPassword = new JLabel("密码：");
		// 密码框
		JPasswordField tfPassword = new JPasswordField("password");
		//pf.setText("password");
		tfPassword.setPreferredSize(new Dimension(80, 30));
		// 与文本框不同，获取密码框里的内容，推荐使用getPassword，该方法会返回一个字符数组，而非字符串
		char[] password = tfPassword.getPassword();
		String p = String.valueOf(password);
		System.out.println(p);
		f.add(lName);
		f.add(tfName);
		f.add(lPassword);
		f.add(tfPassword);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		tfPassword.grabFocus();
	}
}
