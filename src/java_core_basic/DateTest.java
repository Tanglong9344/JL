package java_core_basic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateTest {
	public static void main(String[] args) {
		//时间格式化
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sf3 = new SimpleDateFormat("MM/dd/yyyy");

		Date date = new Date();
		System.out.println("日期:"+date);
		System.out.println("日期格式化1:"+sf1.format(date));
		System.out.println("日期格式化2:"+sf2.format(date));
		System.out.println("日期格式化3:"+sf3.format(date));
		System.out.println("调用 System.currentTimeMillis()："+System.currentTimeMillis());

		//随机函数Math.Random()
		System.out.println("Math.Random():");
		for(int i=0;i<10;i++) {
			System.out.print("随机数:"+(int)(Math.random()*10)+" ");
		}

		//随机函数java.util.random()
		System.out.println("\njava.util.random():");
		for(int i=0;i<10;i++) {
			System.out.print("随机数:"+ new Random().nextInt(10)+" ");
		}

		System.out.println("\njava.util.random(),浮点数:");
		for(int i=0;i<10;i++) {
			System.out.print("随机数:"+ new Random().nextFloat()+" ");
		}
		System.out.println("\njava.util.random()，长整型:");
		for(int i=0;i<10;i++) {
			System.out.print("随机数:"+ new Random().nextLong()+" ");
		}
	}
}
