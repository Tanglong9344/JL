package java_junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test JUnit Suit
 *
 * @author Administrator
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({SumJUnit.class, JUnitAnnotations.class})
public class SuitTest {}