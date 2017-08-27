package java_core_basic;

public class StringSubStringTest {
	public static void main(String[] args) {
		String myStr = "Hello World!";
		String myStrSub = myStr.substring(myStr.lastIndexOf("e"),myStr.lastIndexOf("r"));
		System.out.println("myStrSub:"+myStrSub);
	}
}
