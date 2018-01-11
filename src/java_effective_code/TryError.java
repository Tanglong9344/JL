package java_effective_code;

/**
 * try...catch(Error)
 *
 * @author ÌÆÁú
 *
 */
public class TryError {
	public static void main(String[] args) {
		String s = "String";
		int cnt = 0;
		while(true) {
			cnt++;
			try {
				s += s;
			} catch(Error e) {     // catch 'Java heap space' error
				// e.printStackTrace();
				System.err.println("Error: " + e);
				break;
			}
		}
		System.out.println("cnt=" + cnt);
	}
}