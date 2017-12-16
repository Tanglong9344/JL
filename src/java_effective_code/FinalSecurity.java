package java_effective_code;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Test for Class Array
 * @author ÌÆÁú
 */
public class FinalSecurity {
	public static void main(String[] args) {
		// Test for ARR_UNSAFE
		System.out.println("Before modification: " + Arrays.toString(Array.ARR_UNSAFE));
		Array.ARR_UNSAFE[0] = "Bye  ";
		System.out.println("After modification : " + Arrays.toString(Array.ARR_UNSAFE));

		// Test for ARR_SAFE
		System.out.println("Return in List     : " + Array.valuesList());
		System.out.println("Return as a Clone  : " + Arrays.toString(Array.valuesClone()));
	}
}

/**Class with two String[] in public and private*/
class Array{
	/** Potential security hole,the values in ARR_UNSAFE can be modified*/
	public static final String[] ARR_UNSAFE = {"Hello","final","String"};
	/** Using private the prevent ARR_SAFE from being modified*/
	private static final String[] ARR_SAFE = {"Hello","final","String"};

	/**Return values of ARR_SAFE in List*/
	public static final List<String> valuesList(){
		return Collections.unmodifiableList(Arrays.asList(ARR_SAFE));
	}

	/**Return values of ARR_SAFE as a clone */
	public static final String[] valuesClone(){
		return ARR_SAFE.clone();
	}
}