package java_effective_base_method;

/**
 * 二维点类(x,y)
 * @author 唐龙
 */
public class PointEqualsXY extends PointEqualsX{
	private double y;

	/**构造方法*/
	public PointEqualsXY(double x,double y){
		super(x);
		this.y = y;
	}

	/**equals*/
	@Override
	public boolean equals(Object o){
		if(o instanceof PointEqualsXY){
			return super.equals(o) && y == ((PointEqualsXY)o).getY();
		}
		return false;
	}

	/**toString*/
	@Override
	public String toString(){
		return super.toString() + ", " + y;
	}

	// getter and setter
	public double getY() {
		return y;
	}
}