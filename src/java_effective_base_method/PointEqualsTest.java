package java_effective_base_method;

/**
 * Point 测试类
 * 覆盖equals方法需要满足：
 * 1.自反性(reflexivity)
 * 2.对称性(symmetric)
 * 3.传递性(transitive)
 * 4.一致性(consistent)
 * 5.null与任何非null比较总会返回false
 * @author 唐龙
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
	}
}