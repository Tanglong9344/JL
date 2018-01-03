package java_common;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * define System.out.println() as print()
 *
 * @author ÌÆÁú
 */
public class P {
	// String
	public static void print(String str) {
		System.out.println(str);
	}

	// char
	public static void print(char c) {
		System.out.println(c);
	}

	// char[]
	public static void print(char[] chs) {
		System.out.println(chs);
	}

	// int
	public static void print(int i) {
		System.out.println(i);
	}

	// int[]
	public static void print(int[] is) {
		System.out.println(Arrays.toString(is));
	}

	// long
	public static void print(long l) {
		System.out.println(l);
	}

	// long[]
	public static void print(long[] ls) {
		System.out.println(Arrays.toString(ls));
	}

	// float
	public static void print(float f) {
		System.out.println(f);
	}

	// float[]
	public static void print(float[] fs) {
		System.out.println(Arrays.toString(fs));
	}

	// double
	public static void print(double d) {
		System.out.println(d);
	}

	// double[]
	public static void print(double[] ds) {
		System.out.println(Arrays.toString(ds));
	}

	// boolean
	public static void print(boolean b) {
		System.out.println(b);
	}

	// boolean[]
	public static void print(boolean[] bs) {
		System.out.println(Arrays.toString(bs));
	}

	// byte
	public static void print(byte by) {
		System.out.println(by);
	}

	// byte[]
	public static void print(byte[] bs) {
		System.out.println(Arrays.toString(bs));
	}

	// List
	public static <V> void print(List<V> list) {
		System.out.print("[");
		list.forEach(l->System.out.print(l + ","));
		System.out.println("]");
	}

	// Map
	public static <K,V> void print(Map<K,V> map) {
		Set<K> ks        = map.keySet();
		System.out.print("[");
		for(Iterator<K> it=ks.iterator();it.hasNext();) {
			K k = it.next();
			System.out.print(k + ":" + map.get(k) + ",");
		}
		System.out.print("]");
	}
}