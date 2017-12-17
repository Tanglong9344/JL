package java_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
/**
 * Annotation for the name of table
 * @author ÌÆÁú
 *
 */
public @interface MyTable {
	/**Name of table*/
	String name();
}