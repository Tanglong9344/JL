package java_effective_code;

/**
 * Test Figure class
 *
 * @author 牝霜
 */
public class FigureTest {
	public static void main(String[] args) {
		// Tag Class
		FigureTagClass circleT = new FigureTagClass(2);
		System.out.println(circleT.toString() + ", 中持: " + circleT.area());

		FigureTagClass recT = new FigureTagClass(3,4);
		System.out.println(recT.toString() + ", 中持: " + recT.area());

		// Hierarchy Class
		Figure circle = new Circle(2);
		System.out.println(circle.toString() + ", 中持: " + circle.area());

		Figure rec = new Rectangle(3,4);
		System.out.println(rec.toString() + ", 中持: " + rec.area());
	}
}