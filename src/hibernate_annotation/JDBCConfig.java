package hibernate_annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target 表示这个注解能放在什么位置上，是只能放在类上？还是即可以放在方法上，又可以放在属性上。自定义注解@JDBCConfig 这个注解上的@Target是：@Target({METHOD,TYPE})，表示他可以用在方法和类型上（类和接口），但是不能放在属性等其他位置。 可以选择的位置列表如下：
 * ElementType.TYPE：能修饰类、接口或枚举类型
 * ElementType.FIELD：能修饰成员变量
 * ElementType.METHOD：能修饰方法
 * ElementType.PARAMETER：能修饰参数
 * ElementType.CONSTRUCTOR：能修饰构造器
 * ElementType.LOCAL_VARIABLE：能修饰局部变量
 * ElementType.ANNOTATION_TYPE：能修饰注解
 * ElementType.PACKAGE：能修饰包
 */

/**表示这个注解可以用用在类/接口上，还可以用在方法上*/
@Target({ElementType.TYPE,ElementType.METHOD})

/**
 * RetentionPolicy.SOURCE： 注解只在源代码中存在，编译成class之后，就没了。@Override 就是这种注解。
 * RetentionPolicy.CLASS： 注解在java文件编程成.class文件后，依然存在，但是运行起来后就没了。@Retention的默认值，即当没有显示指定@Retention的时候，就会是这种类型。
 * RetentionPolicy.RUNTIME： 注解在运行起来之后依然存在，程序可以通过反射获取这些信息，自定义注解@JDBCConfig 就是这样。
 */

/**
 * 表示这是一个运行时注解
 * ，即运行起来之后，才获取注解中的相关信息
 * ，而不像基本注解如@Override 那种不用运行
 * ，在编译时eclipse就可以进行相关工作的编译时注解。
 * */
@Retention(RetentionPolicy.RUNTIME)
/**@Inherited 表示这个注解可以被子类继承*/
@Inherited
/**表示当执行javadoc的时候，本注解会生成相关文档*/
@Documented
/**
 * 当没有@Repeatable修饰的时候，注解在同一个位置，只能出现一次，如例所示：
 * @JDBCConfig(database = "test",loginName = "root", password = "12345678")
 * @JDBCConfig(database = "test",loginName = "root", password = "12345678")
 * 重复做两次就会报错了。
 * 使用@Repeatable之后，再配合一些其他动作，就可以在同一个地方使用多次了。
 */
public @interface JDBCConfig {
	String ip() default "127.0.0.1";
	int port() default 3306;
	String database();
	String encoding() default "UTF-8";
	String loginName();
	String password();
}
