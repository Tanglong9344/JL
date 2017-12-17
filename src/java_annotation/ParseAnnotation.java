package java_annotation;

import java.lang.reflect.Method;

/**
 * Annotation parsing
 *
 * @author 唐龙
 *
 */
public class ParseAnnotation {
	public static void main(String[] args) {
		Class<MyAnnotation> clazz = MyAnnotation.class;
		MyEntity myEntity = clazz.getAnnotation(MyEntity.class);
		if (null == myEntity) {
			System.out.println("MyAnnotation类不是实体类");
		} else {
			System.out.println("MyAnnotation类是实体类");
			MyTable myTable= clazz.getAnnotation(MyTable.class);
			String tableName = myTable.name();
			System.out.println("表名: " + tableName);

			Method[] methods =clazz.getMethods();
			Method key = null;//key method

			// loop for key method
			for (Method m : methods) {
				MyId myId = m.getAnnotation(MyId.class);
				if(null != myId){
					key = m;
					break;
				}
			}

			//Major key
			if(null != key){
				System.out.println("主键:");
				MyColumn column = key.getAnnotation(MyColumn.class);
				System.out.format("  属性: %s \t对应的数据库字段是: %s%n",attr(key.getName()),column.value());
				MyGenerate generate = key.getAnnotation(MyGenerate.class);
				System.out.println("  自增长策略: " + generate.strategy());
			}

			// other keys
			System.out.println("其他非主键属性分别对应的数据库字段如下: ");
			for (Method m: methods) {
				if(m == key){ continue; }
				MyColumn column = m.getAnnotation(MyColumn.class);
				// 没有MyColumn注解的方法
				if(null == column) { continue; }
				System.out.format("  属性: %s \t对应的数据库字段是: %s%n",attr(m.getName()),column.value());
			}
		}
	}

	/**Get attribute from methodName*/
	private static String attr(String methodName) {
		String tmp = methodName;
		tmp = tmp.replaceFirst("get", "");
		return tmp.length() <= 1 ? tmp.toLowerCase() :
			tmp.substring(0,1).toLowerCase() + tmp.substring(1,tmp.length());
	}
}