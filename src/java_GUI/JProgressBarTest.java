package java_GUI;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class JProgressBarTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("������");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new FlowLayout());
		JProgressBar pb = new JProgressBar();
		// ���������ֵ
		pb.setMaximum(100);
		// ��ǰ����
		// pb.setValue(50);
		// ��ʾ��ǰ����
		pb.setStringPainted(true);
		f.add(pb);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		// ��̬���ؽ�����
		for (int i = 0; i <= 100; i++) {
			pb.setValue(i);
			System.out.println(pb.getValue());
			try {
				Thread.currentThread();
				Thread.sleep(100);// ��ʱ100����
			} catch (Exception e) {
			}
			// ѭ��ִ��
			if (100 == i) {
				i = 0;
			}
		}
	}
}