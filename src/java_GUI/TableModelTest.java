package java_GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableModelTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("���");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new BorderLayout());

		//����һ��TableModel
		TableModel tm= new TableModel();
		//�������
		{
			int row = tm.getRowCount();
			int col = tm.getColumnCount();
			System.out.println("�������:"+row);
			System.out.println("�������:"+col);
			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					System.out.printf("[%d,%d]:%s%s",i,j,tm.getValueAt(i,j),", ");
				}
				System.out.println();
			}
		}
		//���� TableModel������ Table
		JTable t = new JTable(tm);
		JScrollPane sp = new JScrollPane(t);

		f.add(sp, BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
