package java_input_output;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class InputStreamTest {

	public static void main(String[] args){
		Workbook workbook;
		Sheet sheet = null;
		int row;
		int col;
		try {
			File f = new File("f:/test.xls");
			workbook = Workbook.getWorkbook(f);//��ȡ���
			sheet = workbook.getSheet(0);//��ȡ����һ����
			row = sheet.getRows();//��ȡ����
			col = sheet.getColumns();//��ȡ����
			System.out.println("����:"+row);
			System.out.println("����:"+col);
			//��ȡ���е�Ԫ�������
			for(int i=0;i<row-1;i++){
				for(int j=0;j<col-1;j++) {
					System.out.print(sheet.getCell(j, i).getContents()+"\t");
				}
				System.out.println();
			}
		}catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
