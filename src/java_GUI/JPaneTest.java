package java_GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JPaneTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("���ʾ��");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(null);

		JPanel p1 = new JPanel();
		// ��������С
		p1.setBounds(50, 50, 300, 60);
		// ������屳����ɫ
		p1.setBackground(Color.RED);
		// ��һ�����û�У���ΪJPanelĬ�Ͼ��ǲ��õ�FlowLayout
		p1.setLayout(new FlowLayout());
		JButton b1 = new JButton("��ť1");
		JButton b2 = new JButton("��ť2");
		JButton b3 = new JButton("��ť3");
		// �Ѱ�ť�������
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);

		JPanel p2 = new JPanel();
		JButton b4 = new JButton("��ť4");
		JButton b5 = new JButton("��ť5");
		JButton b6 = new JButton("��ť6");
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.setBackground(Color.BLUE);
		p2.setBounds(10, 150, 300, 60);

		// �������봰��
		f.add(p1);
		f.add(p2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
