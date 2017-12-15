package java_effective_equals;

/**
 * 一维点类(x)
 * @author 唐龙
 */
public class PointX extends Object{
	private double x;

	/**构造方法*/
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