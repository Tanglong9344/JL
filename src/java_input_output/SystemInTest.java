package java_input_output;

import java.io.InputStream;

/**
 * System.in
 * @author Ã∆¡˙
 */
public class SystemInTest {
	public static void main(String[] args) {
		int i;
		try(InputStream is = System.in;){
			System.out.println(" ‰»Î£∫");
			i = is.read();
			System.out.println(i);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}