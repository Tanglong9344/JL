package java_GUI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JMenuTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("�˵�");
		f.setSize(400, 300);
		f.setLocation(200, 200);

		// �˵���
		JMenuBar mb = new JMenuBar();
		// �˵�
		JMenu jm1 = new JMenu("ˮ��");
		//�˵���
		jm1.add(new JMenuItem("ƻ��"));
		jm1.add(new JMenuItem("�㽶"));
		jm1.add(new JMenuItem("����"));
		jm1.add(new JMenuItem("����"));

		// �˵�
		JMenu jm2 = new JMenu("�߲�");
		//�˵���
		jm2.add(new JMenuItem("����"));
		jm2.add(new JMenuItem("����"));
		jm2.add(new JMenuItem(""));
		jm2.add(new JMenuItem(""));
		jm2.add(new JMenuItem("�ƹ�"));
		jm2.add(new JMenuItem("����"));

		// �˵�
		JMenu jm3 = new JMenu("��ʳ");
		//�˵���
		jm3.add(new JMenuItem("����"));
		jm3.add(new JMenuItem("��ͷ"));
		jm3.add(new JMenuItem("����"));
		jm3.add(new JMenuItem("����"));
		jm3.add(new JMenuItem("���"));
		jm3.add(new JMenuItem("����"));

		// �˵�
		JMenu jm4 = new JMenu("");
		//�˵���
		jm4.add(new JMenuItem("����"));
		jm4.add(new JMenuItem("��"));
		jm4.add(new JMenuItem("����"));
		jm4.add(new JMenuItem("����"));
		jm4.add(new JMenuItem("�н���"));

		// �˵�
		JMenu jm5 = new JMenu("����");

		// �Ѳ˵����뵽�˵���
		mb.add(jm1);
		mb.add(jm2);
		mb.add(jm3);
		mb.add(jm4);
		mb.add(jm5);

		// �Ѳ˵������뵽frame�������õ���set����add
		f.setJMenuBar(mb);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
