package design_mode;

/**
 * 提取当前对象的ID
 *
 * @author 唐龙
 *
 */
public class ObjectSimplify {
	static final String getObjectId(Object o){
		String dest=o.toString();
		String[] strs=dest.split("\\.");//按照‘.’分割
		return strs[strs.length-1];//返回对象ID
	}
}