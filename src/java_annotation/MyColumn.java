package java_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
/**
 * Annotation for column name
 *
 * @author ÌÆÁú
 *
 */
public @interface MyColumn {
	/**column name*/
	String value();
}