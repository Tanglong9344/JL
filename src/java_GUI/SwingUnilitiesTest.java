package java_GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingUnilitiesTest {
	public static void main(String[] args) {
		//new TestFrame().setVisible(true);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TestFrame();
			}
		});
	}
	static class TestFrame extends JFrame {
		private static final long serialVersionUID = 1L;

		public TestFrame() {
			setTitle("初始化线程");
			setSize(400, 300);
			setLocation(200, 200);
			setLayout(null);

			JButton b = new JButton("按钮");
			b.setBounds(50, 50, 280, 30);
			add(b);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			System.out.println("当前线程是否是 事件调度线程: " + SwingUtilities.isEventDispatchThread());
		}
	}
}
