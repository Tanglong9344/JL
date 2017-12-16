/**
 * 注解解析
 *
 * 元注解
 * @Target({METHOD,TYPE}) 表示这个注解可以用用在类/接口上，还可以用在方法上
 * @Retention(RetentionPolicy.RUNTIME) 表示这是一个运行时注解，即运行起来之后，
 * 才获取注解中的相关信息，而不像基本注解如@Override 那种不用运行，在编译时eclipse就可以
 * 进行相关工作的编译时注解。
 * @Inherited 表示这个注解可以被子类继承
 * @Documented 表示当执行javadoc的时候，本注解会生成相关文档
 */

package hibernate_annotation;

import java.lang.reflect.Method;

public class ParseHibernateAnnotation {
	public static void main(String[] args) {
		Class<MyAnnotationHeroTest> clazz = MyAnnotationHeroTest.class;
		MyEntity myEntity = clazz.getAnnotation(MyEntity.class);
		if (null == myEntity) {
			System.out.println("MyAnnotationHeroTest类不是实体类");
		} else {
			System.out.println("MyAnnotationHeroTest类是实体类");
			MyTable myTable= clazz.getAnnotation(MyTable.class);
			String tableName = myTable.name();
			System.out.println("其对应的表名是:" + tableName);
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
				System.out.println("找到主键：" + method2attribute( primaryKeyMethod.getName() ));
				MyGeneratedValue myGeneratedValue=primaryKeyMethod.getAnnotation(MyGeneratedValue.class);
				System.out.println("其自增长策略是：" +myGeneratedValue.strategy());
				MyColumn myColumn = primaryKeyMethod.getAnnotation(MyColumn.class);
				System.out.println("对应数据库中的字段是：" +myColumn.value());
			}
			System.out.println("其他非主键属性分别对应的数据库字段如下：");
			for (Method m: methods) {
				if(m==primaryKeyMethod){
					continue;
				}
				MyColumn myColumn = m.getAnnotation(MyColumn.class);
				//那些setter方法上是没有MyColumn注解的
				if(null==myColumn) {
					continue;
				}
				System.out.format("属性： %s\t对应的数据库字段是:%s%n",method2attribute(m.getName()),myColumn.value());
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
