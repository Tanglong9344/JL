package java_GUI;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ToolTipTextTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("��ť");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(null);

		JButton b = new JButton("��ť");
		//set button's position and size
		b.setBounds(80, 50, 180, 25);
		//set hint message
		b.setToolTipText("����һ����ť!");
		f.add(b);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
