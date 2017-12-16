package java_effective_code;

/**
 * ComplexNumber testing
 * @author ÌÆÁú
 */
public class ComplexNumberTest {
	public static void main(String[] args) {
		System.out.println("ZERO=" + ComplexNumber.ZERO);
		System.out.println("ONE =" + ComplexNumber.ONE);
		System.out.println(" I  =" + ComplexNumber.I);
		System.out.println("MAX =" + ComplexNumber.MAX);
		System.out.println("MIN =" + ComplexNumber.MIN);

		ComplexNumber cn1 = ComplexNumber.valueOf(3,4);
		System.out.println("cn1 =" + cn1.toString() + ",hashCode: " + cn1.hashCode());

		ComplexNumber cn2 = ComplexNumber.valueOf(2,1);
		System.out.println("cn2 =" + cn2.toString() + ",hashCode: " + cn2.hashCode());

		System.out.println("cn1 + cn2=" + cn1.add(cn2).toString());
		System.out.println("cn1 - cn2=" + cn1.substract(cn2).toString());
		System.out.println("cn1 * cn2=" + cn1.multiply(cn2).toString());
		System.out.println("cn1 / cn2=" + cn1.divide(cn2).toString());
	}
}