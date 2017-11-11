package java_excel;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * ʹ��jxl����Excel�ļ���д
 * @author ����
 */
public class ExcelJXL {
	//This is a test
	public static void main(String[] args) throws IOException, WriteException, BiffException{
		String fileName = "src/java_excel/excel.xlsx";
		//д��
		writeExcel(fileName);
		//��ȡ
		readExcel(fileName);
	}

	//д��
	public static void writeExcel(String fileName) throws IOException, RowsExceededException, WriteException{
		final int N = 10;//����������
		File file = new File(fileName);
		// ����һ��������
		WritableWorkbook workbook = Workbook.createWorkbook(file);
		// ����һ��������
		WritableSheet sheet = workbook.createSheet("sheet1", 0);
		int row,col;
		// ���������������
		for (row = 0; row < N; row++){
			for (col = 0; col < N; col++){
				sheet.addCell(new Label(col,row,"Data-jxl"+row+col));
			}
		}
		workbook.write();
		workbook.close();
	}

	//��ȡ
	public static void readExcel(String fileName) throws BiffException, IOException{
		File file = new File(fileName);
		// ��ù��������
		Workbook workbook = Workbook.getWorkbook(file);
		// ������й�����
		Sheet[] sheets = workbook.getSheets();
		int rows,cols,row,col;//�����������������������У���
		// ����������
		if (sheets != null){
			for (Sheet sheet : sheets){
				// �������
				rows = sheet.getRows();
				// �������
				cols = sheet.getColumns();
				// ��ȡ����
				for (row = 0; row < rows; row++){
					for (col = 0; col < cols; col++){
						System.out.printf("%15s", sheet.getCell(col, row).getContents());
					}
					System.out.println();
				}
			}
		}
		workbook.close();
	}
}