package hibernate_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//表示这个注解可以用用在类/接口上
@Target(ElementType.TYPE)
/* 表示这是一个运行时注解，即运行起来之后，才获取注解中的相关信息，
 * 而不像基本注解如@Override 那种不用运行，在编译时eclipse
 * 就可以进行相关工作的编译时注解。*/
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTable {
	String name();
}
