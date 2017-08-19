package java_input_output;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamTest2 {
	public static void main(String[] args) {
		try {
			File f = new File("f:/test.txt");
			// ���������ļ���������
			FileInputStream fis = new FileInputStream(f);
			//�ļ�����
			System.out.println("�ļ�����:"+f.length());
			//�����ֽ����飬�䳤�Ⱦ����ļ��ĳ���
			byte[] all =new byte[(int) f.length()];
			//���ֽ�������ʽ��ȡ�ļ���������
			fis.read(all);
			for (byte b : all) {
				//��ӡ������65 66
				System.out.println(b);
			}
			//ÿ��ʹ����������Ӧ�ý��йر�
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
