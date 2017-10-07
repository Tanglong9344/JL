package java_collection_map;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;

public class StackTest {
	public static void main(String argv[]) {
		FileInputStream input;
		char ch;
		// 创建一个空栈，用于存放字符
		Stack<Character> stack = new Stack<Character>();
		try {
			input = new FileInputStream(FileDescriptor.in);
			System.out.println("入栈操作：");
			//入栈操作
			while ((ch = (char) input.read()) != '\r') {
				stack.push(Character.valueOf(ch));
			}
			input.close();
			//出栈
			System.out.println("出栈操作：");
			while (!stack.empty()) {
				System.out.println(stack.pop());
			}
		} catch (IOException e) {
			System.err.println("输入输出流错误。");
		}
	}
}