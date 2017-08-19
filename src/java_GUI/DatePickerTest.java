package java_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.eltima.components.ui.DatePicker;

public class DatePickerTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("���ڻ�ȡ");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(null);

		final DatePicker datepick;
		datepick = getDatePicker();
		f.add(datepick);
		JButton b = new JButton("��ȡʱ��");
		b.setBounds(137, 183, 100, 30);//position and size
		f.add(b);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "��ȡ�ؼ��е����ڣ�" + datepick.getValue());
				System.out.println(datepick.getValue());
			}
		});
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	private static DatePicker getDatePicker() {
		final DatePicker datepick;
		// ��ʽ
		String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
		// ��ǰʱ��
		Date date = new Date();
		// ����
		Font font = new Font("Times New Roman", Font.BOLD, 14);
		Dimension dimension = new Dimension(300, 30);
		int[] hilightDays = { 1, 3, 5, 7 };
		int[] disabledDays = { 4, 6, 5, 9 };
		datepick = new DatePicker(date, DefaultFormat, font, dimension);
		datepick.setLocation(137, 83);
		datepick.setBounds(130, 85, 180, 25);
		// ����һ���·�����Ҫ������ʾ������
		datepick.setHightlightdays(hilightDays, Color.red);
		// ����һ���·��в���Ҫ�����ӣ��ʻ�ɫ��ʾ
		datepick.setDisableddays(disabledDays);
		// ���ù���
		datepick.setLocale(Locale.CHINA);
		// ����ʱ�����ɼ�
		datepick.setTimePanleVisible(true);
		return datepick;
	}
}
