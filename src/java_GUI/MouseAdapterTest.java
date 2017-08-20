package java_GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseAdapterTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("ͼƬ����ʾ������");
		f.setSize(400, 300);
		f.setLocation(580, 200);
		f.setLayout(null);

		final JLabel l = new JLabel();
		ImageIcon i = new ImageIcon("f:/Firefox.png");
		l.setIcon(i);
		l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

		// MouseAdapter ��������ֻ��Ҫ��д�õ��ķ�����û���õ��ľͲ���д��
		l.addMouseListener(new MouseAdapter() {
			// ֻ��mouseEntered�õ���
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

