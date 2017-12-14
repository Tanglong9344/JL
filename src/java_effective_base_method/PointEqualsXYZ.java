package java_effective_base_method;

/**
 * 三维维点类(x,y,z)
 * @author 唐龙
 */
public class PointEqualsXYZ extends PointEqualsXY{
	private double z;

	/**构造方法*/
	public PointEqualsXYZ(double x,double y,double z){
		super(x,y);
		this.z = z;
	}

	/**equals*/
	@Override
	public boolean equals(Object o){
		if(o instanceof PointEqualsXYZ){
			return super.equals(o) && z == ((PointEqualsXYZ)o).getZ();
		}
		return false;
	}

	/**toString*/
	@Override
	public String toString(){
		return super.toString() + ", " + z;
	}

	// getter and setter
	public double getZ() {
		return z;
	}
}