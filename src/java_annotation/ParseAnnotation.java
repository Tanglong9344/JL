package java_annotation;

import java.lang.reflect.Method;

/**
 * Annotation parsing
 *
 * @author ����
 *
 */
public class ParseAnnotation {
	public static void main(String[] args) {
		Class<MyAnnotation> clazz = MyAnnotation.class;
		MyEntity myEntity = clazz.getAnnotation(MyEntity.class);
		if (null == myEntity) {
			System.out.println("MyAnnotation�಻��ʵ����");
		} else {
			System.out.println("MyAnnotation����ʵ����");
			MyTable myTable= clazz.getAnnotation(MyTable.class);
			String tableName = myTable.name();
			System.out.println("����: " + tableName);

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
				System.out.println("����:");
				MyColumn column = key.getAnnotation(MyColumn.class);
				System.out.format("  ����: %s \t��Ӧ�����ݿ��ֶ���: %s%n",attr(key.getName()),column.value());
				MyGenerate generate = key.getAnnotation(MyGenerate.class);
				System.out.println("  ����������: " + generate.strategy());
			}

			// other keys
			System.out.println("�������������Էֱ��Ӧ�����ݿ��ֶ�����: ");
			for (Method m: methods) {
				if(m == key){ continue; }
				MyColumn column = m.getAnnotation(MyColumn.class);
				// û��MyColumnע��ķ���
				if(null == column) { continue; }
				System.out.format("  ����: %s \t��Ӧ�����ݿ��ֶ���: %s%n",attr(m.getName()),column.value());
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