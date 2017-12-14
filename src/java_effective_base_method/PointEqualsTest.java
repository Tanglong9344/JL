package java_effective_base_method;

/**
 * Point ������
 * ����equals������Ҫ���㣺
 * 1.�Է���(reflexivity)
 * 2.�Գ���(symmetric)
 * 3.������(transitive)
 * 4.һ����(consistent)
 * 5.null���κη�null�Ƚ��ܻ᷵��false
 * @author ����
 */
public class PointEqualsTest {
	public static void main(String[] args) {
		PointEqualsX px = new PointEqualsX(12);
		System.out.println("px: " + px.toString());

		PointEqualsXY pxy = new PointEqualsXY(12,3);
		System.out.println("pxy: " + pxy.toString());

		PointEqualsXYZ pxyz = new PointEqualsXYZ(12,3,4);
		System.out.println("pxyz: " + pxyz.toString());

		// Comparison
		// ���ǵķ���������Գ���(symmetric)
		System.out.println("------px to others-------");
		System.out.println(px.equals(px));
		System.out.println(px.equals(pxy));
		System.out.println(px.equals(pxyz));

		System.out.println("------pxy to others-------");
		System.out.println(pxy.equals(px));
		System.out.println(pxy.equals(pxy));
		System.out.println(pxy.equals(pxyz));

		System.out.println("------pxyz to others-------");
		System.out.println(pxyz.equals(px));
		System.out.println(pxyz.equals(pxy));
		System.out.println(pxyz.equals(pxyz));
	}
}