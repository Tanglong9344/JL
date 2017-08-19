package java_input_output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterTest {
	public static void main(String[] args) {
		File f = new File("f:test.txt");
		// �����ļ��ַ���
		// ���������뽨����һ�����ڵ����Ļ�����
		try (
				// �����ļ��ַ���
				FileWriter fw = new FileWriter(f);
				// ���������뽨����һ�����ڵ����Ļ�����               
				PrintWriter pw = new PrintWriter(fw);               
				) {
				pw.println("I am Chinese!");
				pw.println("�����й���!");
				pw.println("�������֣�˵�߾��ߣ�");
				pw.flush();//ˢ�»���
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
