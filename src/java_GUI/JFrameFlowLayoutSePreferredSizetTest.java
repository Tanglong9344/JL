package java_GUI;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameFlowLayoutSePreferredSizetTest {
	public static void main(String[] args) {
		// ������
		JFrame f = new JFrame("���μ�");
		// ���������ô�С
		f.setSize(400, 300);
		// ����������λ��
		f.setLocation(200, 200);
		// ���ò�����ΪFlowLayerout
		// �����ϵ����ˮƽ�ڷ�
		f.setLayout(new FlowLayout());
		JButton b1 = new JButton("Ӣ��1");
		JButton b2 = new JButton("Ӣ��2");
		JButton b3 = new JButton("Ӣ��3");

		// ���� ʹ�� ������ ��Ҳ���� ͨ��setPreferredSize���򲼾�������������ʾ�Ĵ�С
		b3.setPreferredSize(new Dimension(180, 40));
		// ���뵽�������ɣ����赥��ָ����С��λ��
		f.add(b1);
		f.add(b2);
		f.add(b3);
		// �رմ����ʱ���˳�����
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �ô����ÿɼ�
		f.setVisible(true);
	}
}
