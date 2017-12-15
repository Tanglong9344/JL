package java_effective_equals;

/**
 * ��άά����(x,y,z)
 * ����ʵ��(�������ڼ̳�)
 * @author ����
 */
public class PointCompoundXYZ{
	private double z;
	private PointCompoundXY pointxy;

	/**���췽��*/
	public PointCompoundXYZ(double x,double y,double z){
		pointxy = new PointCompoundXY(x,y);
		this.z = z;
	}

	/**equals*/
	@Override
	public boolean equals(Object o){
		if(o instanceof PointCompoundXYZ){
			PointCompoundXYZ pxyz = (PointCompoundXYZ)o;
			return pointxy.equals(pxyz.pointxy) && z - pxyz.getZ() < Common.GAP;
		}
		return false;
	}

	/**toString*/
	@Override
	public String toString(){
		return pointxy.toString() + ", " + z;
	}

	// getter and setter
	public double getZ() {
		return z;
	}
}