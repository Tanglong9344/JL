package java_GUI;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JScrollPaneTest {
	public static void main(String[] args) {
		final int NUM=1000;
		JFrame f=new JFrame("�������");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(null);

		//׼��һ���ı���������źܶ�����
		JTextArea ta=new JTextArea();
		for (int i=0; i < NUM; i++) {
			ta.append(String.valueOf(i*i));
		}
		//�Զ�����
		ta.setLineWrap(true);
		//������
		JScrollPane sp=new JScrollPane(ta);
		f.setContentPane(sp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}