package java_junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test JUnit Annotation
 *
 * 目前支持的主要注解有：
 * 1. @BeforeClass 全局只会执行一次，而且是第一个运行(在所有测试之前)
 * 2. @Before 在每个测试运行之前执行
 * 3. @Test 测试方法,指示测试用例
 * 4. @After 在测试方法运行之后允许
 * 5. @AfterClass 全局只会执行一次，而且是最后一个运行
 * 6. @Ignore 忽略此方法
 *
 * @author 唐龙
 *
 */
public class JUnitAnnotations {

	private ArrayList<String> testList;

	@BeforeClass
	public static void onceExecutedBeforeAll() {
		System.out.println("@BeforeClass: onceExecutedBeforeAll");
	}

	@Before
	public void executedBeforeEach() {
		testList = new ArrayList<String>();
		System.out.println("@Before: executedBeforeEach");
	}

	@AfterClass
	public static void onceExecutedAfterAll() {
		System.out.println("@AfterClass: onceExecutedAfterAll");
	}

	@After
	public void executedAfterEach() {
		testList.clear();
		System.out.println("@After: executedAfterEach");
	}

	@Test
	public void EmptyCollection() {
		assertTrue(testList.isEmpty());
		System.out.println("@Test: EmptyArrayList");
	}

	@Test
	public void OneItemCollection() {
		testList.add("oneItem");
		assertEquals(1, testList.size());
		System.out.println("@Test: OneItemArrayList");
	}

	@Ignore
	public void executionIgnored() {
		System.out.println("@Ignore: This execution is ignored");
	}
}