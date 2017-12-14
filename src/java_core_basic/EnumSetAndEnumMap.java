package java_core_basic;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * EnumSet and EnumMap
 * @author ����
 */
public class EnumSetAndEnumMap {
	public static void main(String[] args) {
		//ö�ٷ�������
		System.out.println("Weekend.����һ: " + Weekend.����һ);
		System.out.println("Weekend.���ڶ�.toString(): " + Weekend.���ڶ�.toString());
		System.out.println("Weekend.������.name(: " + Weekend.������.name());
		System.out.println("Weekend.������.hashCode(): " + Weekend.������.hashCode());
		System.out.println("Weekend.������.ordinal(): " + Weekend.������.ordinal());
		System.out.println("Weekend.������.getVal(): " + Weekend.������.getVal());
		System.out.println("Weekend.������.getClass(): " + Weekend.������.getClass());

		//EnumSet
		System.out.println("---------------EnumSet---------------");
		EnumSet<Weekend> es = EnumSet.allOf(Weekend.class);
		System.out.println("EnumSet: " + es);

		//EnumMap
		System.out.println("---------------EnumMap---------------");
		EnumMap<Weekend,String> em = new EnumMap<Weekend, String>(Weekend.class);
		em.put(Weekend.����һ, "Monday");
		em.put(Weekend.������, "Wednesday");
		em.put(Weekend.������, "Saturday");
		System.out.println(em);
	}
}

/**ö��*/
enum Weekend{
	������(0),
	����һ(1),
	���ڶ�(2),
	������(3),
	������(4),
	������(5),
	������(6);

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