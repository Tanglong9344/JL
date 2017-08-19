package java_GUI;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JTabbledPaneTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("选择面板");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(null);

		JPanel p1 = new JPanel();
		p1.setBounds(50, 50, 300, 60);
		p1.setBackground(Color.RED);
		p1.setLayout(new FlowLayout());
		JButton b1 = new JButton("按钮1");
		JButton b2 = new JButton("按钮2");
		JButton b3 = new JButton("按钮3");
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);

		JPanel p2 = new JPanel();
		JButton b4 = new JButton("按钮4");
		JButton b5 = new JButton("按钮5");
		JButton b6 = new JButton("按钮6");
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.setBackground(Color.BLUE);
		p2.setBounds(10, 150, 300, 60);

		JPanel p3 = new JPanel();
		JButton b7 = new JButton("按钮7");
		JButton b8 = new JButton("按钮8");
		JButton b9 = new JButton("按钮9");
		p3.add(b7);
		p3.add(b8);
		p3.add(b9);
		p3.setBackground(Color.GREEN);
		p3.setBounds(10, 150, 300, 60);

		JPanel p4 = new JPanel();
		JButton b10 = new JButton("按钮10");
		JButton b11= new JButton("按钮11");
		JButton b12 = new JButton("按钮12");
		p4.add(b10);
		p4.add(b11);
		p4.add(b12);
		p4.setBackground(Color.YELLOW);
		p4.setBounds(10, 150, 300, 60);

		JTabbedPane tp = new JTabbedPane();
		tp.add(p1);
		tp.add(p2);
		tp.add(p3);
		tp.add(p4);
		// 设置tab的标题
		tp.setTitleAt(0, "红色tab");
		tp.setTitleAt(1, "蓝色tab");
		tp.setTitleAt(2, "绿色tab");
		tp.setTitleAt(3, "黄色tab");
		f.setContentPane(tp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}