package java_GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListenerTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("鼠标动作监听");
		f.setSize(400, 300);
		f.setLocation(580, 200);
		f.setLayout(null);

		final JLabel l = new JLabel();
		ImageIcon i = new ImageIcon("f:/Firefox.png");
		l.setIcon(i);
		l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

		l.addMouseListener(new MouseListener() {
			  
		// 释放鼠标
		public void mouseReleased(MouseEvent e){}

		// 按下鼠标
		public void mousePressed(MouseEvent e) {}

		// 鼠标退出
		 public void mouseExited(MouseEvent e) {
			 Random r = new Random();
			 int x = r.nextInt(f.getWidth() - l.getWidth());
			 int y = r.nextInt(f.getHeight() - l.getHeight());
			 l.setLocation(x, y);
		 }

		 // 鼠标进入
		 public void mouseEntered(MouseEvent e) {
			 Random r = new Random();
			 int x = r.nextInt(f.getWidth() - l.getWidth());
			 int y = r.nextInt(f.getHeight() - l.getHeight());
			 l.setLocation(x, y);
		 }

		 // 按下释放组合动作为点击鼠标
		public void mouseClicked(MouseEvent e) {}

		});
		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}