package java_GUI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class NotePadTextPractice {
		public static void main(String[] args) {
			JFrame f = new JFrame("�½��ı��ĵ� - ���±�");
			f.setSize(450, 500);
			f.setLocation(200, 200);

			// �˵���
			JMenuBar mb = new JMenuBar();
			// �˵�
			JMenu jm1 = new JMenu("�ļ�(F)");
			//�˵���
			jm1.add(new JMenuItem("�½�(N)        Ctrl + N"));
			jm1.add(new JMenuItem("��(O)...     Ctrl + O"));
			jm1.add(new JMenuItem("����(S)        Ctrl + S"));
			jm1.add(new JMenuItem("���Ϊ(A)..."));
			jm1.add(new JMenuItem("------------------------"));
			jm1.add(new JMenuItem("ҳ������(U)..."));
			jm1.add(new JMenuItem("��ӡ(P)...     Ctrl + P"));
			jm1.add(new JMenuItem("------------------------"));
			jm1.add(new JMenuItem("�˳�(X)"));

			// �˵�
			JMenu jm2 = new JMenu("�༭(E)");
			//�˵���
			jm2.add(new JMenuItem("����(U)        Ctrl + Z"));
			jm2.add(new JMenuItem("------------------------"));
			jm2.add(new JMenuItem("����(T)        Ctrl + X"));
			jm2.add(new JMenuItem("����(C)        Ctrl + C"));
			jm2.add(new JMenuItem("ճ��(P)        Ctrl + V"));
			jm2.add(new JMenuItem("ɾ��(L)        Del"));
			jm2.add(new JMenuItem("------------------------"));
			jm2.add(new JMenuItem("����(F)...     Ctrl + F"));
			jm2.add(new JMenuItem("������һ��(N)    F3"));
			jm2.add(new JMenuItem("�滻(R)...     Ctrl + H"));
			jm2.add(new JMenuItem("ת��(G)...     Ctrl + G"));
			jm2.add(new JMenuItem("ȫѡ(A)        Ctrl + A"));
			jm2.add(new JMenuItem("ʱ��/����(D)    F5"));

			// �˵�
			JMenu jm3 = new JMenu("��ʽ(O)");
			//�˵���
			jm3.add(new JMenuItem("�Զ�����(W)"));
			jm3.add(new JMenuItem("����(F)..."));

			// �˵�
			JMenu jm4 = new JMenu("�鿴(V)");
			//�˵���
			jm4.add(new JMenuItem("״̬��(S)"));

			// �˵�
			JMenu jm5 = new JMenu("����(H)");
			jm5.add(new JMenuItem("�鿴����(H)"));
			jm5.add(new JMenuItem("------------------------"));
			jm5.add(new JMenuItem("���ڼ��±�(A)"));

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