package java_effective_equals;

/**
 * һά����(x)
 * @author ����
 */
public class PointX extends Object{
	private double x;

	/**���췽��*/
	public PointX(double x){
		this.x = x;
	}

	/**equals*/
	@Override
	public boolean equals(Object o){
		if(o instanceof PointX){
			return x -((PointX)o).getX() < Common.GAP;
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