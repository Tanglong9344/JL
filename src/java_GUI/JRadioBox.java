package java_GUI;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class JRadioBox {
	public static void main(String[] args) { 
		JFrame f = new JFrame("��ѡ��");
		f.setSize(400, 300);
		f.setLocation(580, 200);
		f.setLayout(null);

		JRadioButton b1 = new JRadioButton("ƻ��");
		// ���� Ϊ Ĭ�ϱ�ѡ��
		b1.setSelected(true);
		b1.setBounds(50, 50, 130, 30);

		JRadioButton b2 = new JRadioButton("�㽶");
		b2.setBounds(50, 100, 130, 30);
		System.out.println("b1�Ƿ�ѡ��:"+b1.isSelected());
		System.out.println("b2�Ƿ�ѡ��:"+b2.isSelected());
		f.add(b1);
		f.add(b2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
