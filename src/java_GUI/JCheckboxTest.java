package java_GUI;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class JCheckboxTest {
	public static void main(String[] args) { 
		JFrame f = new JFrame("��ѡ��");
		f.setSize(400, 300);
		f.setLocation(580, 200);
		f.setLayout(null);

		JCheckBox bCheckBox = new JCheckBox("ƻ��");
		//���� Ϊ Ĭ�ϱ�ѡ�� 
		bCheckBox.setSelected(true);
		bCheckBox.setBounds(50, 50, 130, 30);

		JCheckBox bCheckBox2 = new JCheckBox("�㽶");
		bCheckBox2.setBounds(50, 100, 130, 30);
		//�ж� �Ƿ� �� ѡ�� 
		System.out.println("bCheckBox�Ƿ�ѡ��:"+bCheckBox.isSelected());
		System.out.println("bCheckBox2�Ƿ�ѡ��:"+bCheckBox2.isSelected());
		f.add(bCheckBox);
		f.add(bCheckBox2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
