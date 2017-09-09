package java_core_basic;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		//随机函数Math.Random()
		System.out.println("Math.Random():");
		for(int i=0;i<10;i++) {
			System.out.print("随机数:"+(int)(Math.random()*10)+" ");
		}

		//随机函数java.util.random()
		Random rm = new Random();
		System.out.println("\njava.util.random()，整数:");
		for(int i=0;i<10;i++) {
			System.out.print("随机数:"+ rm.nextInt(10)+" ");
		}

		System.out.println("\njava.util.random()，浮点数:");
		for(int i=0;i<10;i++) {
			System.out.print("随机数:"+ rm.nextFloat()+" ");
		}

		System.out.println("\njava.util.random()，长整型:");
		for(int i=0;i<10;i++) {
			System.out.print("随机数:"+ rm.nextLong()+" ");
		}
	}
}