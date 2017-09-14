package java_GUI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class KeyAdapterTest extends KeyAdapter implements ActionListener {
	JFrame f = null;
	JLabel label = null;
	JTextField tField = null;
	String keyString = "";
	public KeyAdapterTest() {
		f = new JFrame("���̼���");// Ϊ���JFrame����һ������
		Container contentPane = f.getContentPane();
		contentPane.setLayout(new GridLayout(3, 1));
		label = new JLabel();// ����һ����ǩ����
		tField = new JTextField();
		tField.requestFocus();
		tField.addKeyListener(this);
		JButton b = new JButton("���");// ����һ����ť
		b.addActionListener(this);
		contentPane.add(label);
		contentPane.add(tField);
		contentPane.add(b);
		f.pack();
		f.show();
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		keyString = "";
		label.setText("");
		tField.setText("");
		tField.requestFocus();
	}
	//������ĸ"O"֮�󣬻�����´���
	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();/* ע��getKeyChar()���÷� */
		if (c == 'o') {
			JFrame newF = new JFrame("�´���");
			newF.setSize(200, 200);
			newF.show();
		}
		keyString = keyString + c;
		label.setText(keyString);
	}
	public static void main(String[] args) {
		new KeyAdapterTest();
	}
}