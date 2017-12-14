package java_core_basic;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * EnumSet and EnumMap
 * @author 唐龙
 */
public class EnumSetAndEnumMap {
	public static void main(String[] args) {
		//枚举方法测试
		System.out.println("Weekend.星期一: " + Weekend.星期一);
		System.out.println("Weekend.星期二.toString(): " + Weekend.星期二.toString());
		System.out.println("Weekend.星期五.name(: " + Weekend.星期五.name());
		System.out.println("Weekend.星期三.hashCode(): " + Weekend.星期三.hashCode());
		System.out.println("Weekend.星期四.ordinal(): " + Weekend.星期四.ordinal());
		System.out.println("Weekend.星期六.getVal(): " + Weekend.星期六.getVal());
		System.out.println("Weekend.星期日.getClass(): " + Weekend.星期日.getClass());

		//EnumSet
		System.out.println("---------------EnumSet---------------");
		EnumSet<Weekend> es = EnumSet.allOf(Weekend.class);
		System.out.println("EnumSet: " + es);

		//EnumMap
		System.out.println("---------------EnumMap---------------");
		EnumMap<Weekend,String> em = new EnumMap<Weekend, String>(Weekend.class);
		em.put(Weekend.星期一, "Monday");
		em.put(Weekend.星期三, "Wednesday");
		em.put(Weekend.星期六, "Saturday");
		System.out.println(em);
	}
}

/**枚举*/
enum Weekend{
	星期日(0),
	星期一(1),
	星期二(2),
	星期三(3),
	星期四(4),
	星期五(5),
	星期六(6);

	private int val;

	/**constructor*/
	private Weekend(int val){
		this.val = val;
	}

	// getter
	public int getVal() {
		return val;
	}
}