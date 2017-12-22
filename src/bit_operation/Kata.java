package bit_operation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Kata {
	public static void main(String[] args  ) {
		String[] strs = new String []{  "3  ",   "9  ",   "A  ",   "5  ",   "T  ",   "8  ",   "2  ",   "4  ",   "Q  ",   "7  ",   "J  ",   "6  ",   "K  "};
		System.out.println(Arrays.toString(strs  )  );
		System.out.println(Arrays.toString(sortCards(strs  )  )  );
	}
	public static String[] sortCards (String[] cards  ) {
		return selectSort(cards);
	}

	/**Select Sort*/
	private static String[] selectSort(String[] arr  ){
		Map<String, Integer> m = new HashMap<String,Integer>(  );
		m.put("A", 1);
		m.put("2", 2);
		m.put("3", 3);
		m.put("4", 4);
		m.put("5", 5);
		m.put("6", 6);
		m.put("7", 7);
		m.put("8", 8);
		m.put("9", 9);
		m.put("T", 10);
		m.put("J", 11);
		m.put("Q", 12);
		m.put("K", 13);
		String swap;
		for(int i=0,len = arr.length,j,minPos;i<len-1;i++  ){
			minPos=i;
			for(j=i+1;j<len;j++){
				if(m.get(arr[j])<m.get(arr[minPos])){minPos=j;}
			}
			if(minPos != i){
				swap = arr[i];
				arr[i] = arr[minPos];
				arr[minPos] = swap;
			}
		}
		return arr;
	}
}