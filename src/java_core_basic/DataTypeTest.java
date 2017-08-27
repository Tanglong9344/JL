package java_core_basic;

public class DataTypeTest {
	public static void main(String[] args) {
		//正无穷大和负无穷大
		System.out.println("POSITIVE_INFINITY:"+Double.POSITIVE_INFINITY);
		System.out.println("NEGATIVE_INFINITY:"+Double.NEGATIVE_INFINITY);
		System.out.println("NaN:"+Double.NaN);

		System.out.format("POSITIVE_INFINITY:%f\n",Double.POSITIVE_INFINITY);

		final int NUMBER = 32767;

		Double dNum = new Double(NUMBER);//8 bytes
		Float  fNum = new Float(NUMBER);//4 bytes

		Long   lNum = new Long(NUMBER);//8 bytes (-2^47)~(2^47-)
		Integer    iNum = new Integer(NUMBER);//4 bytes (-2^31)~(2^31-1)
		Short      sNum = new Short((short)NUMBER);//2 bytes,(-2^15)~(2^15-1)
		Byte       bNum = new Byte((byte)NUMBER);//1 byte, (-2^7)~(2^7-1)

		Character       cc   = new Character('H');

		Boolean         bb   = new Boolean(true);

		System.out.println("Float Number:"+fNum);
		System.out.println("Double Number:"+dNum);
		System.out.println("Long Number:"+lNum);
		System.out.println("Integer Number:"+iNum);
		System.out.println("Short Number:"+sNum);
		System.out.println("Byte Number:"+bNum);

		System.out.println("Character:"+cc);

		System.out.println("Boolean:"+bb);
	}
}
