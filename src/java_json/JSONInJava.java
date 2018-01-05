package java_json;

import static java_common.CommonUtils.getList;
import static java_common.CommonUtils.getMap;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * JSON Êý¾Ý×ª»»
 *
 * @author ÌÆÁú
 *
 */
public class JSONInJava {
	private static final int SIZE = 3;
	public static void main(String[] args) {
		List<String> list = getList(SIZE);
		// JSONArray-List
		JSONArray jsonArr = JSONArray.fromObject(list);
		System.out.println(jsonArr);

		// JSONArray-Array
		JSONArray jsonArr2 = JSONArray.fromObject(new int[]{1,2,3});
		System.out.println(jsonArr2);

		// JSONArray-general Object
		JSONArray jsonArr3 = JSONArray.fromObject("['Hello','JSON']");
		System.out.println(jsonArr3);

		Map<String,String> map = getMap(SIZE);
		// JSONObject-Map
		JSONObject jsonObj = JSONObject.fromObject(map);
		System.out.println(jsonObj);

		// JSONObject-JavaBean
		Person p = new Person();
		System.out.println(p.toString());
		JSONObject jsonObj2 = JSONObject.fromObject(p);
		System.out.println(jsonObj2);

		// From JSON to JavaBean
		Person p2 = (Person) JSONObject.toBean(jsonObj2,Person.class);
		System.out.println(p2.toString());
	}
}