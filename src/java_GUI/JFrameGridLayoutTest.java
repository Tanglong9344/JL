package java_GUI;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameGridLayoutTest {
	public static void main(String[] args) {
		// 主窗体
		JFrame f = new JFrame("西游记");
		// 主窗体设置大小
		f.setSize(400, 300);
		// 主窗体设置位置
		f.setLocation(200, 200);
		// 设置布局器为GridLayerout，即网格布局器
		// 该GridLayerout的构造方法表示该网格是2行3列
		f.setLayout(new GridLayout(2, 3));

		JButton b1 = new JButton("洪七");
		JButton b2 = new JButton("段智兴");
		JButton b3 = new JButton("欧阳锋");
		JButton b4 = new JButton("黄药师");
		JButton b5 = new JButton("周伯通");
		JButton b6 = new JButton("郭靖");

		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		// 关闭窗体的时候，退出程序
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 让窗体变得可见
		f.setVisible(true);
	}
}
