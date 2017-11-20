package java_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 比较ArrayList和LinkedList的平均查找时间
 * @author 唐龙
 */
public class ListSearch {
	public static void main(String[] args) {
		System.out.println("-------ArrayList Search------");
		search("ArrayList");
		System.out.println("-------LinkedList Search------");
		search("LinkedList");
	}

	//测试方法
	public static void search(String choose){
		final int M = 1000_000;//元素个数
		final int N = 100;//查找次数
		//创建集合并初始化
		List<String> strs = null;
		if("ArrayList".equals(choose)){
			strs = new ArrayList<String>();
		}else if("LinkedList".equals(choose)){
			strs = new LinkedList<String>();
		}
		for (int j = 0; j < M; j++) {
			strs.add("str-"+j);
		}
		// 进行N次查找并统计查找时间平均值
		int avg = 0;
		for (int i = 0; i < N; i++) {
			// 打乱strs中元素的顺序
			Collections.shuffle(strs);
			long start = System.currentTimeMillis();
			String target = "str-10000";
			for (String str : strs) {
				if (target.equals(str)) {break;}
			}
			long end = System.currentTimeMillis();
			avg += end - start;
		}
		System.out.printf("对%d个元素查找%d次,平均花费%d毫秒%n",M,N,avg);
	}
}