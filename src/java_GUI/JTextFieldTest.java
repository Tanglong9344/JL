package java_GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JTextFieldTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("�ı���");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new FlowLayout());

		JLabel lName = new JLabel("�˺ţ�");
		// �����
		//JTextField tfName = new JTextField("�������˺�");
		JTextField tfName = new JTextField("");
		tfName.setText("�������˺�");
		tfName.setPreferredSize(new Dimension(80, 30));

		JLabel lPassword = new JLabel("���룺");
		// �����
		JPasswordField tfPassword = new JPasswordField("password");
		//pf.setText("password");
		tfPassword.setPreferredSize(new Dimension(80, 30));
		// ���ı���ͬ����ȡ�����������ݣ��Ƽ�ʹ��getPassword���÷����᷵��һ���ַ����飬�����ַ���
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
