package java_process;

import java.io.IOException;

public class ProcessBuilderTest {
	public static void main(String[] args) throws IOException {
		//�������������
		//�򿪼�����
		ProcessBuilder pbc = new ProcessBuilder("calc");
		//ִ��
		pbc.start();
		//�ü��±���test.java
		ProcessBuilder pbd = new ProcessBuilder("notepad","test.java");
		//ִ��
		pbd.start();
	}
}