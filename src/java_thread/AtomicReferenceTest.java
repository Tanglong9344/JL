package java_thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference
 *
 * @author ÌÆÁú
 *
 */
public class AtomicReferenceTest {
	public static void main(String[] args) {
		final int N = 6;
		AtomicReference<String> ar = new AtomicReference<String>(">");
		for(int i=0;i<N;i++) {
			ar.getAndUpdate(r-> "-" + r);
			System.out.println(ar);
		}
	}
}