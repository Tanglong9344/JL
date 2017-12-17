package java_effective_code;

import static java_effective_code.CommonConstants.GAP;

/**
 * ��άά����(x,y,z)
 * �̳�ʵ��
 * @author ����
 */
public class PointExtendsXYZ extends PointExtendsXY{
	private double z;

	/**���췽��*/
	public PointExtendsXYZ(double x,double y,double z){
		super(x,y);
		this.z = z;
	}

	/**equals*/
	@Override
	public boolean equals(Object o){
		if(o instanceof PointExtendsXYZ){
			return super.equals(o) && z - ((PointExtendsXYZ)o).getZ() < GAP;
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