package java_GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyListenerTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("ͼƬ�����������ƶ���");
		f.setSize(500, 400);//��С
		f.setLocation(600, 200);//λ��
		f.setLayout(null);//��ʽ

		final JLabel l = new JLabel();
		ImageIcon i = new ImageIcon("f:/Firefox.png");
		l.setIcon(i);
		l.setBounds(180, 100, i.getIconWidth(), i.getIconHeight());
		// ���Ӽ��̼���
		f.addKeyListener(new KeyListener() {
			// ��������
			public void keyReleased(KeyEvent e) {
				// 37 ��ʾ�����ƶ��İ���
				if(e.getKeyCode() == 37){
					// ͼƬ�����ƶ� ��x������٣�y���겻�䣩
					l.setLocation(l.getX()-10, l.getY());
				}
				// 38 ��ʾ�����ƶ��İ���
				if(e.getKeyCode() == 38){
					// ͼƬ�����ƶ� ��x���겻�䣬y������٣�
					l.setLocation(l.getX(), l.getY()-10);
				}
				// 39 ��ʾ�����ƶ��İ���
				if (e.getKeyCode() == 39) {
					// ͼƬ�����ƶ� ��y���겻�䣬x�������ӣ�
					l.setLocation(l.getX() + 10, l.getY());
				}
				// 40 ��ʾ�����ƶ��İ���
				if(e.getKeyCode() == 40){
					// ͼƬ�����ƶ� ��x���겻�䣬y�������ӣ�
					l.setLocation(l.getX(), l.getY()+10);
				}
			}
			//��������
			public void keyPressed(KeyEvent e) {
				// 37 ��ʾ�����ƶ��İ���
				if(e.getKeyCode() == 37){
					// ͼƬ�����ƶ� ��x������٣�y���겻�䣩
					l.setLocation(l.getX()-10, l.getY());
				}
				// 38 ��ʾ�����ƶ��İ���
				if(e.getKeyCode() == 38){
					// ͼƬ�����ƶ� ��x���겻�䣬y������٣�
					l.setLocation(l.getX(), l.getY()-10);
				}
				// 39 ��ʾ�����ƶ��İ���
				if (e.getKeyCode() == 39) {
					// ͼƬ�����ƶ� ��y���겻�䣬x�������ӣ�
					l.setLocation(l.getX() + 10, l.getY());
				}
				// 40 ��ʾ�����ƶ��İ���
				if(e.getKeyCode() == 40){
					// ͼƬ�����ƶ� ��x���겻�䣬y�������ӣ�
					l.setLocation(l.getX(), l.getY()+10);
				}
			}
			// һ�����µ������϶���
			public void keyTyped(KeyEvent e) {
				// 37 ��ʾ�����ƶ��İ���
				if(e.getKeyCode() == 37){
					// ͼƬ�����ƶ� ��x������٣�y���겻�䣩
					l.setLocation(l.getX()-10, l.getY());
				}
				// 38 ��ʾ�����ƶ��İ���
				if(e.getKeyCode() == 38){
					// ͼƬ�����ƶ� ��x���겻�䣬y������٣�
					l.setLocation(l.getX(), l.getY()-10);
				}
				// 39 ��ʾ�����ƶ��İ���
				if (e.getKeyCode() == 39) {
					// ͼƬ�����ƶ� ��y���겻�䣬x�������ӣ�
					l.setLocation(l.getX() + 10, l.getY());
				}
				// 40 ��ʾ�����ƶ��İ���
				if(e.getKeyCode() == 40){
					// ͼƬ�����ƶ� ��x���겻�䣬y�������ӣ�
					l.setLocation(l.getX(), l.getY()+10);
				}
			}
		});
		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}

