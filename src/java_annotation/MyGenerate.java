package java_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//方法注解
@Retention(RetentionPolicy.RUNTIME)//运行时保留
/**
 * Annotation for Generate Strategy
 *
 * @author 唐龙
 *
 */
public @interface MyGenerate {
	String strategy();
}