package java_process;

import java.io.IOException;

public class RunTimeTest {
	public static void main(String[] args) throws IOException {
		//打开计算器
		Runtime.getRuntime().exec("calc");
		//打开记事本
		Runtime.getRuntime().exec("notepad test.java");
	}
}
