package java_effective_code;

/**
 * Rectangle class extends Figure
 *
 * @author ÌÆÁú
 *
 */
public class Rectangle extends Figure{
	private final double width;
	private final double length;

	public Rectangle(double width, double length){
		this.width  = width;
		this.length = length;
	}

	@Override
	public double area() {
		return width * length;
	}

	/**toString*/
	@Override
	public String toString(){
		return "width: " + width + ", length: " + length;
	}
}