package java_GUI;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class JProgressBarTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("进度条");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new FlowLayout());
		JProgressBar pb = new JProgressBar();
		// 进度条最大值
		pb.setMaximum(100);
		// 当前进度
		// pb.setValue(50);
		// 显示当前进度
		pb.setStringPainted(true);
		f.add(pb);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		// 动态加载进度条
		for (int i = 0; i <= 100; i++) {
			pb.setValue(i);
			System.out.println(pb.getValue());
			try {
				Thread.currentThread();
				Thread.sleep(100);// 延时100毫秒
			} catch (Exception e) {
			}
			// 循环执行
			if (100 == i) {
				i = 0;
			}
		}
	}
}