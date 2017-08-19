package java_GUI;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameLocationTest {
	public static void main(String[] args) {
		// 主窗体
		JFrame f = new JFrame("西游记");
		// 主窗体设置大小
		f.setSize(400, 300);
		// 主窗体设置位置
		f.setLocation(200, 200);
		// 主窗体中的组件设置为绝对定位
		f.setLayout(null);
		// 按钮组件
		JButton b1 = new JButton("英雄1");
		// 指定位置和大小
		b1.setBounds(50, 50, 80, 30);
		JButton b2 = new JButton("英雄2");
		b2.setBounds(150, 50, 80, 30);
		JButton b3 = new JButton("英雄3");
		b3.setBounds(250, 50, 80, 30);
		// 没有指定位置和大小，不会出现在容器上
		JButton b4 = new JButton("英雄3");
 
		f.add(b1);
		f.add(b2);
		f.add(b3);
		// b4没有指定位置和大小，不会出现在容器上
		f.add(b4);
		// 关闭窗体的时候，退出程序
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 让窗体变得可见
		f.setVisible(true);
	}
}
