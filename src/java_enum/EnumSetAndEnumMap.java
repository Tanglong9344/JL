package java_enum;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

/**
 * EnumSet and EnumMap
 *
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
		System.out.println("Weekend.������.serialNum(): " + Weekend.������.serialNum());
		System.out.println("Weekend.������.getClass(): " + Weekend.������.getClass());

		/**EnumSet*/
		System.out.println("---------------EnumSet---------------");
		// allof
		Set<Weekend> es = EnumSet.allOf(Weekend.class);
		System.out.println("EnumSet: " + es);

		//of
		Set<Weekend> es2 = EnumSet.of(Weekend.������, Weekend.������);
		System.out.println("EnumSet: " + es2);

		/**EnumMap*/
		System.out.println("---------------EnumMap---------------");
		Map<Weekend,String> em = new EnumMap<Weekend, String>(Weekend.class);
		em.put(Weekend.����һ, "Monday");
		em.put(Weekend.������, "Wednesday");
		em.put(Weekend.������, "Saturday");
		System.out.println(em);
	}
}

/**ö��*/
enum Weekend{
	������(0), ����һ(1), ���ڶ�(2), ������(3), ������(4), ������(5), ������(6);

	private final int serialNum; // Serial number of each day in a week

	/**constructor*/
	private Weekend(int serialNum){
		this.serialNum = serialNum;
	}

	public int serialNum() {
		return serialNum;
	}
}