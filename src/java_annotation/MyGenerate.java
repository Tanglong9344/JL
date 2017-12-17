package java_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
/**
 * Annotation for Generate Strategy
 *
 * @author ÌÆÁú
 *
 */
public @interface MyGenerate {
	String strategy();
}