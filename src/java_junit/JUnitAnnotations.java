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
 * Ŀǰ֧�ֵ���Ҫע���У�
 * 1. @BeforeClass ȫ��ֻ��ִ��һ�Σ������ǵ�һ������(�����в���֮ǰ)
 * 2. @Before ��ÿ����������֮ǰִ��
 * 3. @Test ���Է���,ָʾ��������
 * 4. @After �ڲ��Է�������֮������
 * 5. @AfterClass ȫ��ֻ��ִ��һ�Σ����������һ������
 * 6. @Ignore ���Դ˷���
 *
 * @author ����
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