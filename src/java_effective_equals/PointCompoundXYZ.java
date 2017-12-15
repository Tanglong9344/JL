package java_effective_equals;

/**
 * 三维维点类(x,y,z)
 * 复合实现(复合优于继承)
 * @author 唐龙
 */
public class PointCompoundXYZ{
	private double z;
	private PointCompoundXY pointxy;

	/**构造方法*/
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