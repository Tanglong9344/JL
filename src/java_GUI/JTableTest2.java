package java_GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableTest2 {
	public static void main(String[] args) {
		JFrame f = new JFrame("���");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new BorderLayout());

		// ����ϵ�title
		String[] header = new String[] { "����", "�Ա�", "���", "����" };
		// ����е����ݣ���һ����ά����
		String[][] content = new String[][] {
			 { "�ź�", "��", "�ų�", "δ֪" }
			,{ "�ܲ�", "��", "�߳�", "70kg" }
			, { "С��", "Ů", "168cm", "45kg" }
			, { "����", "Ů", "172cm", "55kg" }
			, { "���", "��", "188cm", "70kg" }
			, { "������", "��", "178cm", "65kg" }
			, { "����", "Ů", "171cm", "53kg" }
			};
		JTable t = new JTable(content, header);
		// ����t���� JScrollPane,�����Ϳ��Կ�����������
		JScrollPane sp = new JScrollPane(t);
		//���򴴽�һ���յ�JScrollPane����ͨ��setViewportView��table����JScrollPane��
		// JScrollPane sp = new JScrollPane(t);
		// sp.setViewportView(t);
		// ��sp����JTable���뵽JFrame��
		// �����п��
		t.getColumnModel().getColumn(0).setPreferredWidth(250);
		f.add(sp, BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
