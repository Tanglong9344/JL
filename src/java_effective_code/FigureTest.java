package java_effective_code;

/**
 * Test Figure class
 *
 * @author ����
 */
public class FigureTest {
	public static void main(String[] args) {
		// Tag Class
		FigureTagClass circleT = new FigureTagClass(2);
		System.out.println(circleT.toString() + ", ���: " + circleT.area());

		FigureTagClass recT = new FigureTagClass(3,4);
		System.out.println(recT.toString() + ", ���: " + recT.area());

		// Hierarchy Class
		Figure circle = new Circle(2);
		System.out.println(circle.toString() + ", ���: " + circle.area());

		Figure rec = new Rectangle(3,4);
		System.out.println(rec.toString() + ", ���: " + rec.area());
	}
}