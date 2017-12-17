package java_effective_code;

/**
 * Tag Class including circle as well as rectangle
 *
 * Weaknesses of Tag Class
 * 1. Bad readability(has enumeration declaration as well as many tag fields and conditional statements)
 * 2. More memory(Redundant code)
 * 3. Poor efficiency(many tag fields and conditional statements)
 * 4. More easy to get into mistakes(many conditional statements)
 *
 * @author ÌÆÁú
 */
public class FigureTagClass {
	private enum Shape{ CIRCLE, RECTANGLE };

	/**Tag field - the shape of this figure*/
	private Shape shape;

	/**This field is used only if the shape is CIRCLE*/
	private double radius;

	/**These field are used only if the shape is RECTANGLE*/
	private double width;
	private double length;

	/**Constructor for circle*/
	public FigureTagClass(double radius){
		shape = Shape.CIRCLE;
		this.radius = radius;
	}

	/**Constructor for rectangle*/
	public FigureTagClass(double width,double length){
		shape = Shape.RECTANGLE;
		this.width  =width;
		this.length = length;
	}

	/**Compute the area of this figure*/
	public double area(){
		return shape == Shape.CIRCLE ? Math.PI * (radius * radius) : width * length;
	}

	/**toString*/
	@Override
	public String toString(){
		return shape == Shape.CIRCLE ? "radius: " + radius
				: "width: " + width + ", length: " + length;
	}
}