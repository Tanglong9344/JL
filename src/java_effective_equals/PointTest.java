package java_effective_equals;

/**
 * Point 测试类
 * 覆盖equals方法需要满足：
 * 1.自反性(reflexivity)
 * 2.对称性(symmetric)
 * 3.传递性(transitive)
 * 4.一致性(consistent)
 * 5.非空性(所有的对象都不等于null)
 * @author 唐龙
 */
public class PointTest {
	public static void main(String[] args) {
		// 继承方式
		System.out.println("----------继承方式-----------");
		PointX px = new PointX(12);
		System.out.println("px: " + px.toString());

		PointExtendsXY pxy = new PointExtendsXY(12,3);
		System.out.println("pxy: " + pxy.toString());

		PointExtendsXYZ pxyz = new PointExtendsXYZ(12,3,4);
		System.out.println("pxyz: " + pxyz.toString());

		// Comparison
		// 覆盖的方法不满足对称性(symmetric)
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

		// 组合方式
		System.out.println("----------组合方式-----------");
		System.out.println("px: " + px.toString());

		PointCompoundXY pxy2 = new PointCompoundXY(12,3);
		System.out.println("pxy2: " + pxy2.toString());

		PointCompoundXYZ pxyz2 = new PointCompoundXYZ(12,3,4);
		System.out.println("pxyz2: " + pxyz2.toString());

		// Comparison
		// 覆盖的方法满足对称性(symmetric)
		System.out.println("------px to others-------");
		System.out.println(px.equals(px));
		System.out.println(px.equals(pxy2));
		System.out.println(px.equals(pxyz2));

		// 组合方式
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