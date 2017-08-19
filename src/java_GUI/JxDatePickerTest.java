package java_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.JXDatePicker;

public class JxDatePickerTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("JXDatePickerʱ���ȡ");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(null);

		Date date = new Date();
		final JXDatePicker datepick = new JXDatePicker();
		// ���� date����
		datepick.setDate(date);
		datepick.setBounds(130, 85, 180, 25);
		f.add(datepick);
		JButton b = new JButton("��ȡʱ��");
		b.setBounds(137, 183, 100, 30);
		f.add(b);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ȡ ����
				Date d = datepick.getDate();
				JOptionPane.showMessageDialog(f, "��ȡ�ؼ��е����� :" + d);
			}
		});
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
