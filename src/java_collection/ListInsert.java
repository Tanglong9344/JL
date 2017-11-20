package java_collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 比较ArrayList和LinkedList的元素插入平均时间
 * @author 唐龙
 */
public class ListInsert {
	public static void main(String[] args) {
		System.out.println("-------ArrayList Insert------");
		insert("ArrayList");
		System.out.println("-------LinkedList Insert------");
		insert("LinkedList");
	}

	//测试方法
	public static void insert(String choose){
		final int M = 1000_000;//元素个数
		//创建集合并初始化
		List<String> strs = null;
		if("ArrayList".equals(choose)){
			strs = new ArrayList<String>();
		}else if("LinkedList".equals(choose)){
			strs = new LinkedList<String>();
		}
		//插入M个元素所用时间的平均值
		int avg = 0;
		long start = System.currentTimeMillis();
		for (int j = 0; j < M; j++) {
			strs.add("str-"+j);
		}
		long end = System.currentTimeMillis();
		avg += end - start;
		System.out.printf("插入%d个元素平均花费%d毫秒%n",M,avg);
	}
}