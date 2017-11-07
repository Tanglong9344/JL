package java_process;

import java.io.IOException;

public class ProcessBuilderTest {
	public static void main(String[] args) throws IOException {
		//创建计算机进程
		//打开计算器
		ProcessBuilder pbc = new ProcessBuilder("calc");
		//执行
		pbc.start();
		//用记事本打开test.java
		ProcessBuilder pbd = new ProcessBuilder("notepad","test.java");
		//执行
		pbd.start();
	}
}