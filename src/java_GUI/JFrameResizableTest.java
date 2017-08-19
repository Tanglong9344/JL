package java_GUI;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameResizableTest {
	public static void main(String[] args) {
		// 主窗体
		JFrame f = new JFrame("窗体大小不可变");
		// 主窗体设置大小
		f.setSize(400, 300);
		// 主窗体设置位置
		f.setLocation(200, 200);
		// 主窗体中的组件设置为绝对定位
		f.setLayout(null);
		// 按钮组件
		JButton b = new JButton("窗体大小不可变");
		// 同时设置组件的大小和位置
		b.setBounds(50, 50, 280, 30);
		// 把按钮加入到主窗体中
		f.add(b);
		// 窗体大小不可变化
		f.setResizable(false);
		// 关闭窗体的时候，退出程序
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 让窗体变得可见
		f.setVisible(true);
	}
}
