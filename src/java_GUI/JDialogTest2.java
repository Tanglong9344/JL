package java_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class JDialogTest2 {
	public static void main(String[] args) {
		JFrame f = new JFrame("�ⲿ����");
		f.setSize(800, 600);
		f.setLocation(100, 100);
		
		JButton b = new JButton("����ģ̬����");
		b.setBounds(50, 50, 280, 30);
		f.add(b);
		f.setVisible(true);

		
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("����¼���");
				// �����ⲿ����ʵ����JDialog
				JDialog d = new JDialog(f);
				// ����Ϊģ̬
				d.setModal(true);
				d.setTitle("ģ̬�ĶԻ���");
				d.setSize(400, 300);
				d.setLocation(200, 200);
				d.setLayout(null);

				JButton b1 = new JButton("����ģ̬�ĶԻ���");
				b1.setBounds(50, 50, 280, 30);
				d.add(b1);
				d.setVisible(true);//ֻ�з���JButtonʵ��֮��ť�Ż���ʾ
			}
			
		});
	}
}
