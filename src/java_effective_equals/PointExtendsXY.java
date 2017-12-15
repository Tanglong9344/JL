package java_effective_equals;

/**
 * 二维点类(x,y)
 * 继承实现
 * @author 唐龙
 */
public class PointExtendsXY extends PointX{
	private double y;

	/**构造方法*/
	public PointExtendsXY(double x,double y){
		super(x);
		this.y = y;
	}

	/**equals*/
	@Override
	public boolean equals(Object o){
		if(o instanceof PointExtendsXY){
			return super.equals(o) && y - ((PointExtendsXY)o).getY() < Common.GAP;
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