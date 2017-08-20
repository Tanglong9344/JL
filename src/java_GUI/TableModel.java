package java_GUI;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	// ����ϵ�title
	String[] header = new String[] { "����", "�Ա�", "���", "����" };
	// ����е����ݣ���һ����ά����
	String[][] content = new String[][] {
		 { "�ź�", "��", "�ų�", "δ֪" }
		,{ "�ܲ�", "��", "�߳�", "70kg" }
		, { "С��", "Ů", "168cm", "45kg" }
		, { "����", "Ů", "172cm", "55kg" }
		, { "���", "��", "188cm", "70kg" }
		, { "������", "��", "178cm", "65kg" }
		, { "����", "Ů", "171cm", "53kg" }
		};

	// ����һ���ж�����
	@Override
	public int getRowCount() {
		return content.length;
	}

	@Override
	// ����һ���ж�����
	public int getColumnCount() {
		return header.length;
	}
	// ��ȡÿһ�е�����
	public String getColName(int colIdx) {
		return header[colIdx];
	}

	// ��Ԫ���Ƿ�����޸�
	@Override
	public boolean isCellEditable(int rowIdx, int colIdx) {
		return false;
	}

	// ÿһ����Ԫ�����ֵ
	@Override
	public Object getValueAt(int rowIdx, int colIdx) {
		return content[rowIdx][colIdx];
	}
}
