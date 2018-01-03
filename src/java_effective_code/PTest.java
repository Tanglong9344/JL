package java_effective_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java_common.P;

/**
 * Class P.print() Test
 *
 * @author ÌÆÁú
 *
 */
public class PTest {
	public static void main(String[] args) {
		///String
		P.print("Hello");
		//char
		P.print('A');
		//char[]
		P.print(new char[]{'H','e','l','l','o'});
		//int
		P.print(110);
		// int[]
		int[] ints = new int[] {1,2,3};
		P.print(ints);
		//long
		P.print(110L);
		// long[]
		long[] longs = new long[] {1,2,3};
		P.print(longs);
		//float
		P.print(110f);
		// float[]
		float[] floats = new float[] {1,2,3};
		P.print(floats);
		//double
		P.print(110d);
		// double[]
		double[] doubles = new double[] {1,2,3};
		P.print(doubles);
		//boolean
		P.print(true);
		// boolean[]
		boolean[] booleans = new boolean[] {true,false,true};
		P.print(booleans);
		//byte
		P.print((byte)110);
		// byte[]
		byte[] bytes = new byte[] {1,2,3};
		P.print(bytes);
		//List
		final int N = 10;
		List<String> list = new ArrayList<String>();
		for(int i=1;i<=N;i++) {
			list.add("L" + i);
		}
		P.print(list);
		//Map
		Map<String, String> map = new HashMap<String, String>();
		for(int i=1;i<=N;i++) {
			map.put("K" + i, "V"+i);
		}
		P.print(map);
	}
}