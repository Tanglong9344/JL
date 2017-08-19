package java_GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseAdapterTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("图片的显示和隐藏");
		f.setSize(400, 300);
		f.setLocation(580, 200);
		f.setLayout(null);

		final JLabel l = new JLabel();
		ImageIcon i = new ImageIcon("f:/Firefox.png");
		l.setIcon(i);
		l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

		// MouseAdapter 适配器，只需要重写用到的方法，没有用到的就不用写了
		l.addMouseListener(new MouseAdapter() {
			// 只有mouseEntered用到了
			public void mouseEntered(MouseEvent e) {
				Random r = new Random();
				int x = r.nextInt(f.getWidth() - l.getWidth());
				int y = r.nextInt(f.getHeight() - l.getHeight());
				l.setLocation(x, y);
			}
		});
		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}

