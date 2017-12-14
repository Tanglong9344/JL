package java_effective_base_method;

/**
 * ��άά����(x,y,z)
 * @author ����
 */
public class PointEqualsXYZ extends PointEqualsXY{
	private double z;

	/**���췽��*/
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