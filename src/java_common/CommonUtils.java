package java_common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Common utilities for all classes
 *
 * @author ÌÆÁú
 *
 */
public class CommonUtils {
	/**Generate a List*/
	public static List<String> getList(int size){
		List<String> list = new ArrayList<String>();
		for(int i=1;i<=size;i++){
			list.add("V"+i);
		}
		return list;
	}

	/**Generate a Map*/
	public static Map<String,String> getMap(int size){
		Map<String,String> map = new HashMap<String,String>();
		for(int i=1;i<=size;i++){
			map.put("K"+i,"V"+i);
		}
		return map;
	}
}