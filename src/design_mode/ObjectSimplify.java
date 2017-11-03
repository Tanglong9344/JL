/**
 * 提取当前对象的ID
 */

package design_mode;

public class ObjectSimplify {
	static String getObjectId(Object o){
		String dest=o.toString();
		String[] strs=dest.split("\\.");//按照‘.’分割
		return strs[strs.length-1];//返回对象ID
	}
}
