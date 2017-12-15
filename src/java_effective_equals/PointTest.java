package java_effective_equals;

/**
 * Point ������
 * ����equals������Ҫ���㣺
 * 1.�Է���(reflexivity)
 * 2.�Գ���(symmetric)
 * 3.������(transitive)
 * 4.һ����(consistent)
 * 5.�ǿ���(���еĶ��󶼲�����null)
 * @author ����
 */
public class PointTest {
	public static void main(String[] args) {
		// �̳з�ʽ
		System.out.println("----------�̳з�ʽ-----------");
		PointX px = new PointX(12);
		System.out.println("px: " + px.toString());

		PointExtendsXY pxy = new PointExtendsXY(12,3);
		System.out.println("pxy: " + pxy.toString());

		PointExtendsXYZ pxyz = new PointExtendsXYZ(12,3,4);
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

		// ��Ϸ�ʽ
		System.out.println("----------��Ϸ�ʽ-----------");
		System.out.println("px: " + px.toString());

		PointCompoundXY pxy2 = new PointCompoundXY(12,3);
		System.out.println("pxy2: " + pxy2.toString());

		PointCompoundXYZ pxyz2 = new PointCompoundXYZ(12,3,4);
		System.out.println("pxyz2: " + pxyz2.toString());

		// Comparison
		// ���ǵķ�������Գ���(symmetric)
		System.out.println("------px to others-------");
		System.out.println(px.equals(px));
		System.out.println(px.equals(pxy2));
		System.out.println(px.equals(pxyz2));

		// ��Ϸ�ʽ
		System.out.println("------pxy2 to others-------");
		System.out.println(pxy2.equals(px));
		System.out.println(pxy2.equals(pxy2));
		System.out.println(pxy2.equals(pxyz2));

		System.out.println("------pxyz2 to others-------");
		System.out.println(pxyz2.equals(px));
		System.out.println(pxyz2.equals(pxy2));
		System.out.println(pxyz2.equals(pxyz2));

	}
}