package java_effective_code;

/**
 * Rectangle class extends Figure
 *
 * @author ÌÆÁú
 *
 */
public class Rectangle extends Figure{
	private double width;
	private double length;

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