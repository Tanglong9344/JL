package java_GUI;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class JToolBarTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("工具栏");
		f.setSize(400, 300);
		f.setLocation(200, 200);

		// 工具栏
		JToolBar tb = new JToolBar();
		// 为工具栏增加按钮
		JButton b1 = new JButton(new ImageIcon("f:/Firefox.png"));
		JButton b2 = new JButton(new ImageIcon("f:/Firefox.png"));

		tb.add(b1);
		tb.add(b2);

		// 把工具栏放在north的位置
		f.setLayout(new BorderLayout());
		f.add(tb, BorderLayout.NORTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
