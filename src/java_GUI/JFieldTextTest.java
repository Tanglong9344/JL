package java_GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFieldTextTest {
	public static void main(String[] args) {
		final int MAX_NAME_LENTH = 10;//����������볤��
		final JFrame f = new JFrame("�������");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new BorderLayout());

		//�����
		JPanel p = new JPanel();
		final JLabel lName = new JLabel("����");
		final JTextField tfName = new JTextField("");
		final JLabel lAge= new JLabel("����");
		final JTextField tfAge= new JTextField("");
		JButton bAdd = new JButton("����");
		tfName.setPreferredSize(new Dimension(80, 30));
		tfAge.setPreferredSize(new Dimension(80, 30));

		p.add(lName);
		p.add(tfName);
		p.add(lAge);
		p.add(tfAge);
		p.add(bAdd);
		//���鶯��
		bAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//��������
				String name = tfName.getText().trim();
				//ͨ��name�����ж� �����Ƿ�Ϊ��
				if (0 == name.length()) {
					// �����Ի�����ʾ�û�
					JOptionPane.showMessageDialog(f, "���Ʋ���Ϊ��");
					// ����������ȡ����
					tfName.grabFocus();
					return;
				}
				//�ж����볤���Ƿ����Ҫ��
				if (name.length()>MAX_NAME_LENTH) {
					// �����Ի�����ʾ�û�
					JOptionPane.showMessageDialog(f, "�������ƹ���[1-10]!");
					// ����������ȡ����
					tfName.grabFocus();
					return;
				}
				//�������
				String age = tfAge.getText().trim();
				//����Ƿ�Ϊ��
				if(0 == age.length()){
					JOptionPane.showMessageDialog(f, "���䲻��Ϊ��!");
					tfAge.grabFocus();
					return;
				}
				//��ʽ����
				try {
					//��ageת��Ϊ���ͣ���������쳣NumberFormatException��ʾ�������͸�ʽ
					Integer.parseInt(age);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(f, "����ֻ�������� !");
					tfAge.grabFocus();
					return;
				}
				//��Χ����
				if(Integer.valueOf(age)<0 || Integer.valueOf(age)>200){
					JOptionPane.showMessageDialog(f, "���䳬����Χ[0-200]!");
					tfAge.grabFocus();
					return;
				}
				//����ɹ�
				JOptionPane.showMessageDialog(f, "����ɹ� !");
				return;
			}
		});

		f.add(p, BorderLayout.NORTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}