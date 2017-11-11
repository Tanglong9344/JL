package java_excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * ʹ�� poi ����Excel�ļ���д
 * @author ����
 */
public class ExcelPOI {
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
		FileOutputStream xlsStream = new FileOutputStream(file);
		// ����������
		HSSFWorkbook workbook = new HSSFWorkbook();
		// ����������
		HSSFSheet sheet = workbook.createSheet("sheet1");
		int row,col;
		HSSFRow rows;
		for (row = 0; row < N; row++){
			rows = sheet.createRow(row);//
			// ���������������
			for (col = 0; col < N; col++){
				rows.createCell(col).setCellValue("Data-poi" + row + col);
			}
		}
		//д���ļ�
		workbook.write(xlsStream);
	}

	//��ȡ
	public static void readExcel(String fileName) throws BiffException, IOException{
		File file = new File(fileName);
		// ��ȡ������
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
		int num = wb.getNumberOfSheets();//��������Ŀ
		HSSFSheet sheet;
		for(int i=0;i<num;i++){
			// ��ȡ������
			sheet = wb.getSheetAt(i);
			//���������Ͷ�ȡ
			for (Row row : sheet) {
				for (Cell cell : row) {
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						//�ַ���
						System.out.printf("%15s",cell.getRichStringCellValue().getString());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						if(DateUtil.isCellDateFormatted(cell)) {
							//����
							System.out.printf("%15s",String.valueOf(cell.getDateCellValue()));
						} else{
							//����
							System.out.printf("%15s",cell.getNumericCellValue());
						}
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						//����ֵ
						System.out.printf("%15s",cell.getBooleanCellValue());
						break;
					default:;
					}
				}
				System.out.println();
			}
		}
	}
}