package java_GUI;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameLocationTest {
	public static void main(String[] args) {
		// ������
		JFrame f = new JFrame("���μ�");
		// ���������ô�С
		f.setSize(400, 300);
		// ����������λ��
		f.setLocation(200, 200);
		// �������е��������Ϊ���Զ�λ
		f.setLayout(null);
		// ��ť���
		JButton b1 = new JButton("Ӣ��1");
		// ָ��λ�úʹ�С
		b1.setBounds(50, 50, 80, 30);
		JButton b2 = new JButton("Ӣ��2");
		b2.setBounds(150, 50, 80, 30);
		JButton b3 = new JButton("Ӣ��3");
		b3.setBounds(250, 50, 80, 30);
		// û��ָ��λ�úʹ�С�����������������
		JButton b4 = new JButton("Ӣ��3");
 
		f.add(b1);
		f.add(b2);
		f.add(b3);
		// b4û��ָ��λ�úʹ�С�����������������
		f.add(b4);
		// �رմ����ʱ���˳�����
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �ô����ÿɼ�
		f.setVisible(true);
	}
}
