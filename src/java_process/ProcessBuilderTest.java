package java_process;

import java.io.IOException;

public class ProcessBuilderTest {
	public static void main(String[] args) throws IOException {
		//�������������
		ProcessBuilder pb = new ProcessBuilder("calc");
		//ִ��
		pb.start();
	}
}