package java_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//����ע��
@Retention(RetentionPolicy.RUNTIME)//����ʱ����
/**
 * Annotation for Generate Strategy
 *
 * @author ����
 *
 */
public @interface MyGenerate {
	String strategy();
}