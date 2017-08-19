package java_GUI;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameFlowLayoutSePreferredSizetTest {
	public static void main(String[] args) {
		// 主窗体
		JFrame f = new JFrame("西游记");
		// 主窗体设置大小
		f.setSize(400, 300);
		// 主窗体设置位置
		f.setLocation(200, 200);
		// 设置布局器为FlowLayerout
		// 容器上的组件水平摆放
		f.setLayout(new FlowLayout());
		JButton b1 = new JButton("英雄1");
		JButton b2 = new JButton("英雄2");
		JButton b3 = new JButton("英雄3");

		// 即便 使用 布局器 ，也可以 通过setPreferredSize，向布局器建议该组件显示的大小
		b3.setPreferredSize(new Dimension(180, 40));
		// 加入到容器即可，无需单独指定大小和位置
		f.add(b1);
		f.add(b2);
		f.add(b3);
		// 关闭窗体的时候，退出程序
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 让窗体变得可见
		f.setVisible(true);
	}
}
