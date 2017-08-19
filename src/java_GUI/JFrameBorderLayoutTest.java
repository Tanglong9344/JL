package java_GUI;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameBorderLayoutTest {
	public static void main(String[] args) {
		// 主窗体
		JFrame f = new JFrame("西游记");
		// 主窗体设置大小
		f.setSize(400, 300);
		// 主窗体设置位置
		f.setLocation(200, 200);
		// 设置布局器为BorderLayerout
		// 容器上的组件按照上北下南左西右东中的顺序摆放
		f.setLayout(new BorderLayout());

		JButton b1 = new JButton("洪七");
		JButton b2 = new JButton("段智兴");
		JButton b3 = new JButton("欧阳锋");
		JButton b4 = new JButton("黄药师");
		JButton b5 = new JButton("周伯通");

		// 加入到容器的时候，需要指定位置
		f.add(b1, BorderLayout.NORTH);
		f.add(b2, BorderLayout.SOUTH);
		f.add(b3, BorderLayout.WEST);
		f.add(b4, BorderLayout.EAST);
		f.add(b5, BorderLayout.CENTER);
		// 关闭窗体的时候，退出程序
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 让窗体变得可见
		f.setVisible(true);
	}
}
