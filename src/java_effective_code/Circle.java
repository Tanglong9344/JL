package java_effective_code;

/**
 * Circle class extends Figure
 *
 * @author ÌÆÁú
 *
 */
public class Circle extends Figure{
	private final double radius;

	public Circle(double radius){
		this.radius = radius;
	}

	@Override
	public double area() {
		return Math.PI * (radius * radius);
	}

	/**toString*/
	@Override
	public String toString(){
		return "radius: " + radius;
	}
}