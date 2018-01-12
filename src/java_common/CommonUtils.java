package java_common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Common utilities for all classes
 *
 * @author ÌÆÁú
 *
 */
public class CommonUtils {
	/**
	 * Generate a List
	 *
	 * @param size
	 * @return
	 */
	public static List<String> getList(int size){
		List<String> list = new ArrayList<String>();
		for(int i=1;i<=size;i++){
			list.add("V"+i);
		}
		return list;
	}

	/**
	 * Generate a Map
	 *
	 * @param size
	 * @return
	 */
	public static Map<String,String> getMap(int size){
		Map<String,String> map = new HashMap<String,String>();
		for(int i=1;i<=size;i++){
			map.put("K"+i,"V"+i);
		}
		return map;
	}

	/**
	 * Generate a String
	 *
	 * @param size
	 * @return
	 */
	public static String getString(int length){
		StringBuilder sb = new StringBuilder();
		if(length <=0) {
			return sb.toString();
		}
		Random r = new Random();
		sb.append((char)(r.nextInt(26) + 65));          // first letter is upper case
		for(int i=1;i<length;i++) {
			switch(r.nextInt(4)) {
			case 0:
				sb.append(r.nextInt(10));              // number
				break;
			case 1:
				sb.append((char)(r.nextInt(26) + 65)); // upper case
				break;
			case 2:
				sb.append((char)(r.nextInt(26) + 97)); // lower case
				break;
			case 3:
				sb.append((char)(r.nextInt(1) + 95)); // underline
				break;
			default:break;
			}
		}
		return sb.toString();
	}
}