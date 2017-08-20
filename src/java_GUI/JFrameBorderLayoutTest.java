package java_GUI;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameBorderLayoutTest {
	public static void main(String[] args) {
		// ������
		JFrame f = new JFrame("���μ�");
		// ���������ô�С
		f.setSize(400, 300);
		// ����������λ��
		f.setLocation(200, 200);
		// ���ò�����ΪBorderLayerout
		// �����ϵ���������ϱ����������Ҷ��е�˳��ڷ�
		f.setLayout(new BorderLayout());

		JButton b1 = new JButton("����");
		JButton b2 = new JButton("������");
		JButton b3 = new JButton("ŷ����");
		JButton b4 = new JButton("��ҩʦ");
		JButton b5 = new JButton("�ܲ�ͨ");

		// ���뵽������ʱ����Ҫָ��λ��
		f.add(b1, BorderLayout.NORTH);
		f.add(b2, BorderLayout.SOUTH);
		f.add(b3, BorderLayout.WEST);
		f.add(b4, BorderLayout.EAST);
		f.add(b5, BorderLayout.CENTER);
		// �رմ����ʱ���˳�����
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �ô����ÿɼ�
		f.setVisible(true);
	}
}
