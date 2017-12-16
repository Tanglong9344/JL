/**
 * ע�����
 *
 * Ԫע��
 * @Target({METHOD,TYPE}) ��ʾ���ע�������������/�ӿ��ϣ����������ڷ�����
 * @Retention(RetentionPolicy.RUNTIME) ��ʾ����һ������ʱע�⣬����������֮��
 * �Ż�ȡע���е������Ϣ�����������ע����@Override ���ֲ������У��ڱ���ʱeclipse�Ϳ���
 * ������ع����ı���ʱע�⡣
 * @Inherited ��ʾ���ע����Ա�����̳�
 * @Documented ��ʾ��ִ��javadoc��ʱ�򣬱�ע�����������ĵ�
 */

package hibernate_annotation;

import java.lang.reflect.Method;

public class ParseHibernateAnnotation {
	public static void main(String[] args) {
		Class<MyAnnotationHeroTest> clazz = MyAnnotationHeroTest.class;
		MyEntity myEntity = clazz.getAnnotation(MyEntity.class);
		if (null == myEntity) {
			System.out.println("MyAnnotationHeroTest�಻��ʵ����");
		} else {
			System.out.println("MyAnnotationHeroTest����ʵ����");
			MyTable myTable= clazz.getAnnotation(MyTable.class);
			String tableName = myTable.name();
			System.out.println("���Ӧ�ı�����:" + tableName);
			Method[] methods =clazz.getMethods();
			Method primaryKeyMethod = null;
			for (Method m: methods) {
				MyId myId = m.getAnnotation(MyId.class);
				if(null!=myId){
					primaryKeyMethod = m;
					break;
				}
			}
			if(null!=primaryKeyMethod){
				System.out.println("�ҵ�������" + method2attribute( primaryKeyMethod.getName() ));
				MyGeneratedValue myGeneratedValue=primaryKeyMethod.getAnnotation(MyGeneratedValue.class);
				System.out.println("�������������ǣ�" +myGeneratedValue.strategy());
				MyColumn myColumn = primaryKeyMethod.getAnnotation(MyColumn.class);
				System.out.println("��Ӧ���ݿ��е��ֶ��ǣ�" +myColumn.value());
			}
			System.out.println("�������������Էֱ��Ӧ�����ݿ��ֶ����£�");
			for (Method m: methods) {
				if(m==primaryKeyMethod){
					continue;
				}
				MyColumn myColumn = m.getAnnotation(MyColumn.class);
				//��Щsetter��������û��MyColumnע���
				if(null==myColumn) {
					continue;
				}
				System.out.format("���ԣ� %s\t��Ӧ�����ݿ��ֶ���:%s%n",method2attribute(m.getName()),myColumn.value());
			}
		}
	}
	private static String method2attribute(String methodName) {
		String result = methodName; ;
		result = result.replaceFirst("get", "");
		result = result.replaceFirst("is", "");
		if(result.length()<=1){
			return result.toLowerCase();
		}
		else{
			return result.substring(0,1).toLowerCase() + result.substring(1,result.length());
		}
	}
}
