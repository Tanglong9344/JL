package java_GUI;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class JDialogTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("�ⲿ����");
		f.setSize(800, 600);
		f.setLocation(100, 100);
		f.setVisible(true);

		// �����ⲿ����ʵ����JDialog
		JDialog d = new JDialog(f);
		// ����Ϊģ̬
		d.setModal(true);
		d.setTitle("ģ̬�ĶԻ���");
		d.setSize(400, 300);
		d.setLocation(200, 200);
		d.setLayout(null);

		JButton b = new JButton("�ڶ������");
		b.setBounds(50, 50, 280, 30);
		d.add(b);
		d.setVisible(true);//ֻ�з���JButtonʵ��֮��ť�Ż���ʾ

		// �����ⲿ����ʵ����JDialog
		JDialog d1 = new JDialog(f);
		// ����Ϊģ̬
		d1.setModal(true);
		d1.setTitle("ģ̬�ĶԻ���");
		d1.setSize(400, 300);
		d1.setLocation(200, 200);
		d1.setLayout(null);

		JButton b1 = new JButton("��һ�����");
		b1.setBounds(50, 50, 280, 30);
		d1.add(b1);
		d1.setVisible(true);
	}
}
