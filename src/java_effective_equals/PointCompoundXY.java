package java_effective_equals;

/**
 * ��ά����(x,y)
 * ����ʵ��(�������ڼ̳�)
 * @author ����
 */
public class PointCompoundXY{
	private double y;
	private PointX pointx;

	/**���췽��*/
	public PointCompoundXY(double x,double y){
		pointx = new PointX(x);
		this.y = y;
	}

	/**equals*/
	@Override
	public boolean equals(Object o){
		if(o instanceof PointCompoundXY){
			PointCompoundXY pxy = (PointCompoundXY)o;
			return pointx.equals(pxy.pointx) && y - pxy.getY() < Common.GAP;
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