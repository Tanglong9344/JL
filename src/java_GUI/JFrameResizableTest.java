package java_GUI;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameResizableTest {
	public static void main(String[] args) {
		// ������
		JFrame f = new JFrame("�����С���ɱ�");
		// ���������ô�С
		f.setSize(400, 300);
		// ����������λ��
		f.setLocation(200, 200);
		// �������е��������Ϊ���Զ�λ
		f.setLayout(null);
		// ��ť���
		JButton b = new JButton("�����С���ɱ�");
		// ͬʱ��������Ĵ�С��λ��
		b.setBounds(50, 50, 280, 30);
		// �Ѱ�ť���뵽��������
		f.add(b);
		// �����С���ɱ仯
		f.setResizable(false);
		// �رմ����ʱ���˳�����
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �ô����ÿɼ�
		f.setVisible(true);
	}
}
