package java_GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableModelTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("表格");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new BorderLayout());

		//创建一个TableModel
		TableModel tm= new TableModel();
		//表格数据
		{
			int row = tm.getRowCount();
			int col = tm.getColumnCount();
			System.out.println("表格行数:"+row);
			System.out.println("表格列数:"+col);
			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					System.out.printf("[%d,%d]:%s%s",i,j,tm.getValueAt(i,j),", ");
				}
				System.out.println();
			}
		}
		//根据 TableModel来创建 Table
		JTable t = new JTable(tm);
		JScrollPane sp = new JScrollPane(t);

		f.add(sp, BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
