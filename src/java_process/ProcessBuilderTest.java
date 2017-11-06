package java_process;

import java.io.IOException;

public class ProcessBuilderTest {
	public static void main(String[] args) throws IOException {
		//创建计算机进程
		ProcessBuilder pb = new ProcessBuilder("calc");
		//执行
		pb.start();
	}
}