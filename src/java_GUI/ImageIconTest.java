package java_GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageIconTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("��ʾͼƬ");
		f.setSize(400, 300);
		f.setLocation(580, 200);
		f.setLayout(null);

		JLabel l = new JLabel();
		//����ͼƬ����ImageIcon����
		ImageIcon i = new ImageIcon("F:\\dianzan.gif");
		//����ImageIcon
		l.setIcon(i);
		//label�Ĵ�С����ΪImageIcon,������ʾ������
		l.setBounds(0, 0, i.getIconWidth(), i.getIconHeight());
		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
