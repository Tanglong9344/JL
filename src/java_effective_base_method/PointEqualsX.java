package java_effective_base_method;

/**
 * һά����(x)
 * @author ����
 */
public class PointEqualsX extends Object{
	private double x;

	/**���췽��*/
	public PointEqualsX(double x){
		this.x = x;
	}

	/**equals*/
	@Override
	public boolean equals(Object o){
		if(o instanceof PointEqualsX){
			return x == ((PointEqualsX)o).getX();
		}
		return false;
	}

	/**toString*/
	@Override
	public String toString(){
		return "" + x;
	}

	// getter and setter
	public double getX() {
		return x;
	}
}