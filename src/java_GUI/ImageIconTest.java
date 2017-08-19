package java_GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageIconTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("显示图片");
		f.setSize(400, 300);
		f.setLocation(580, 200);
		f.setLayout(null);

		JLabel l = new JLabel();
		//根据图片创建ImageIcon对象
		ImageIcon i = new ImageIcon("F:\\dianzan.gif");
		//设置ImageIcon
		l.setIcon(i);
		//label的大小设置为ImageIcon,否则显示不完整
		l.setBounds(0, 0, i.getIconWidth(), i.getIconHeight());
		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
