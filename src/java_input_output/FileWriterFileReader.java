package java_input_output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * FileWriter and FileReader
 *
 * @author ����
 */
public class FileWriterFileReader {
	public static void main(String[] args) {
		File f = new File(CommonFileName.fileName);
		fileWriter(f);
		fileReader(f);
	}

	// write data
	private static void fileWriter(File f){
		try (
				FileWriter fw = new FileWriter(f);// �����ļ��ַ���
				PrintWriter pw = new PrintWriter(fw);// ���������뽨����һ�����ڵ����Ļ�����
				) {
			fw.write("����������\n");//FileWriter.write()��ʽд��
			pw.println("I am Tanglong.");//PrintWriter.println()��ʽд��
			pw.flush();//ˢ�»���
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// read data
	private static void fileReader(File f){
		// �����ļ��ַ���
		// ���������뽨����һ�����ڵ����Ļ�����
		String line = null;
		try (
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);) {
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}