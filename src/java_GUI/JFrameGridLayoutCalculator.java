/**
 * 模拟计算机界面
 */

package java_GUI;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameGridLayoutCalculator {
	public static void main(String[] args) {
		// 主窗体
		JFrame f = new JFrame("计算器");
		// 主窗体设置大小
		f.setSize(400, 300);
		// 主窗体设置位置
		f.setLocation(200, 200);
		// 设置布局器为GridLayerout，即网格布局器
		// 该GridLayerout的构造方法表示该网格是4行5列
		f.setLayout(new GridLayout(4, 5));

		JButton b1 = new JButton("7");
		JButton b2 = new JButton("8");
		JButton b3 = new JButton("9");
		JButton b4 = new JButton("/");
		JButton b5 = new JButton("sq");

		JButton b6 = new JButton("4");
		JButton b7 = new JButton("5");
		JButton b8 = new JButton("6");
		JButton b9 = new JButton("*");
		JButton b10 = new JButton("%");
		
		JButton b11 = new JButton("1");
		JButton b12 = new JButton("2");
		JButton b13 = new JButton("3");
		JButton b14 = new JButton("0");
		JButton b15 = new JButton("1/x");
		
		JButton b16 = new JButton("0");
		JButton b17 = new JButton("+/-");
		JButton b18 = new JButton(".");
		JButton b19 = new JButton("/");
		JButton b20 = new JButton("-");

		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);

		f.add(b6);
		f.add(b7);
		f.add(b8);
		f.add(b9);
		f.add(b10);

		f.add(b11);
		f.add(b12);
		f.add(b13);
		f.add(b14);
		f.add(b15);

		f.add(b16);
		f.add(b17);
		f.add(b18);
		f.add(b19);
		f.add(b20);

		// 关闭窗体的时候，退出程序
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 让窗体变得可见
		f.setVisible(true);
	}
}
