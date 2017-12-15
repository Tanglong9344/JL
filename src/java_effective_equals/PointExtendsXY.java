package java_effective_equals;

/**
 * ��ά����(x,y)
 * �̳�ʵ��
 * @author ����
 */
public class PointExtendsXY extends PointX{
	private double y;

	/**���췽��*/
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