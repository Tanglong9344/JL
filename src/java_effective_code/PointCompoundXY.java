package java_effective_code;

import static java_effective_code.CommonConstants.GAP;

/**
 * 二维点类(x,y)
 * 复合实现(复合优于继承)
 * @author 唐龙
 */
public class PointCompoundXY{
	private double y;
	private PointX pointx;

	/**构造方法*/
	public PointCompoundXY(double x,double y){
		pointx = new PointX(x);
		this.y = y;
	}

	/**equals*/
	@Override
	public boolean equals(Object o){
		if(o instanceof PointCompoundXY){
			PointCompoundXY pxy = (PointCompoundXY)o;
			return pointx.equals(pxy.pointx) && y - pxy.getY() < GAP;
		}
		return false;
	}

	/**toString*/
	@Override
	public String toString(){
		return pointx.toString() + ", " + y;
	}

	// getter and setter
	public double getY() {
		return y;
	}
}