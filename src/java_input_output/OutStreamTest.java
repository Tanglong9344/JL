package java_input_output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutStreamTest {
	public static void main(String[] args) {
		try {
			// ׼���ļ�lol2.txt���е������ǿյ�
			File f = new File("f:/lol2.txt");
			// ׼��������2���ֽ����飬��88,89��ʼ�������Ӧ���ַ��ֱ���X,Y
			byte data[] = {88,89,65};
			// ���������ļ��������
			FileOutputStream fos = new FileOutputStream(f);
			// ������д�뵽�����
			fos.write(data);
			// �ر������
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
