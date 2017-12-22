package java_junit;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * [@Rule] Annotation
 *
 * @author ÌÆÁú
 *
 */
public class AnnotationRule {
	@Rule
	public TestName name = new TestName();

	@Test
	public void testA() {
		assertEquals("testA", name.getMethodName());
		System.out.println(name.getMethodName());
	}

	@Test
	public void testB() {
		assertEquals("testB", name.getMethodName());
		System.out.println(name.getMethodName());
	}
}