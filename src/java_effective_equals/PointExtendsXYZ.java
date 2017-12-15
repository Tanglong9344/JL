package java_effective_equals;

/**
 * 三维维点类(x,y,z)
 * 继承实现
 * @author 唐龙
 */
public class PointExtendsXYZ extends PointExtendsXY{
	private double z;

	/**构造方法*/
	public PointExtendsXYZ(double x,double y,double z){
		super(x,y);
		this.z = z;
	}

	/**equals*/
	@Override
	public boolean equals(Object o){
		if(o instanceof PointExtendsXYZ){
			return super.equals(o) && z - ((PointExtendsXYZ)o).getZ() < Common.GAP;
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