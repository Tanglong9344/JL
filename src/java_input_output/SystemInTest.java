package java_input_output;

import java.io.InputStream;

public class SystemInTest {
	public static void main(String[] args) {
		try(InputStream is = System.in;){
			while(true){
				int i = is.read();
				System.out.println(i);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
