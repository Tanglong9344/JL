package java_effective_code;

/**
 * 复数(实部+虚部)的简单实现
 * @author 唐龙
 */
public final class ComplexNumber {
	/**static constant*/
	public static final ComplexNumber ZERO = new ComplexNumber(0,0);
	public static final ComplexNumber ONE  = new ComplexNumber(1,0);
	public static final ComplexNumber  I   = new ComplexNumber(0,1);
	public static final ComplexNumber MAX  = new ComplexNumber(Double.MAX_VALUE,0);
	public static final ComplexNumber MIN  = new ComplexNumber(Double.MIN_VALUE,0);

	private final double rp;//Real part
	private final double ip;//Imaginary part

	/** Cache the hash code for the ComplexNumber object */
	private int hash; // Default to 0

	/**Constructor*/
	private ComplexNumber(double rp, double ip){
		this.rp = rp;
		this.ip = ip;
	}

	/**static factory*/
	public static ComplexNumber valueOf(double rp, double ip){
		return new ComplexNumber(rp, ip);
	}

	/**return real part*/
	public double realPart(){return rp;}

	/**return imaginary part*/
	public double realImaginary(){return ip;}

	/**add*/
	public ComplexNumber add(ComplexNumber cn){
		return new ComplexNumber(rp + cn.rp, ip + cn.ip);
	}

	/**substract*/
	public ComplexNumber substract(ComplexNumber cn){
		return new ComplexNumber(rp - cn.rp, ip - cn.ip);
	}

	/**multiply*/
	public ComplexNumber multiply(ComplexNumber cn){
		return new ComplexNumber(rp * cn.rp - ip * cn.ip, rp * cn.ip + ip * cn.rp);
	}

	/**divide*/
	public ComplexNumber divide(ComplexNumber cn){
		double divisor = cn.rp * cn.rp + cn.ip * cn.ip;
		if(Double.valueOf(divisor).equals(Double.valueOf(0))){
			throw new ArithmeticException("ComplexNumber divide by zero");
		}
		return new ComplexNumber((rp * cn.rp + ip * cn.ip)/divisor, (rp * cn.ip - ip * cn.rp)/divisor);
	}

	/**equals*/
	@Override
	public boolean equals(Object o){
		if(o == this){return true;}
		if(!(o instanceof ComplexNumber)){return false;}
		ComplexNumber cn = (ComplexNumber)o;
		return (Double.compare(rp, cn.rp) == 0)
				&& (Double.compare(ip, cn.ip) == 0);
	}

	/**hashCode*/
	@Override
	public int hashCode(){
		int result = hash;
		if(result == 0){
			result  = 17 + Double.hashCode(rp);
			result += 31* result + Double.hashCode(ip);
			hash = result;
		}
		return result;
	}

	/**toString*/
	@Override
	public String toString(){
		return "(" + rp + "+" + ip + "i)";
	}
}