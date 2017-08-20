package java_GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableSelectionModelTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("���");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new BorderLayout());

		//����һ��TableModel
		TableModel tm= new TableModel();
		//���� TableModel������ Table
		JTable t = new JTable(tm);
		// ׼��һ��Panel�����һ��Label������ʾ������ѡ����
		JPanel p = new JPanel();
		final JLabel l = new JLabel("��ʱδѡ����Ŀ");
		p.add(l);
		JScrollPane sp = new JScrollPane(t);
		// ʹ��selection������������table���ĸ���Ŀ��ѡ��
		t.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					//��ѡ����ĳһ�е�ʱ�򴥷����¼�
					@Override
					public void valueChanged(ListSelectionEvent e) {
						int row = t.getSelectedRow();//�ڼ���
						int col = t.getSelectedColumn();//�ڼ���
						// ����ѡ�е����л�ȡ��Ӧ������
						Object val = tm.getValueAt(row, col);
						// ���±�ǩ����
						l.setText("��ǰѡ�е���ֵ��: " + val);
					}
				});
		f.add(p, BorderLayout.NORTH);

		f.add(sp, BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}