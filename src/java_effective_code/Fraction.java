package java_effective_code;

/**
 * Fraction Operation
 *
 * @author ÌÆÁú
 *
 */
public final class Fraction {
	private final int nu;//numerator
	private final int de;//denominator

	/**Constructor two parameters*/
	public Fraction(int nu, int de){
		int tmp = greatestCommonDivisor(nu, de);
		this.nu = nu / tmp;
		this.de = de / tmp;
	}

	/**Constructor one parameters*/
	public Fraction(int nu){
		this(nu, 1);
	}

	/**add*/
	public Fraction add(Fraction f){
		int tmp = de * f.de / greatestCommonDivisor(de, f.de);
		int newNu = (tmp / de * nu) + (tmp / f.de * f.nu);
		return new Fraction(newNu, tmp);
	}

	/**add*/
	public Fraction add(int value){
		return add(new Fraction(value, 1));
	}

	/**substract*/
	public Fraction substract(Fraction f){
		int tmp = de * f.de / greatestCommonDivisor(de, f.de);
		int newNu = (tmp / de * nu) - (tmp / f.de * f.nu);
		return new Fraction(newNu, tmp);
	}

	/**substract*/
	public Fraction substract(int value){
		return substract(new Fraction(value, 1));
	}

	/**multiply*/
	public Fraction multiply(Fraction f){
		return new Fraction(nu * f.nu, de * f.de);
	}

	/**multiply*/
	public Fraction multiply(int value){
		return multiply(new Fraction(value, 1));
	}

	/**divide*/
	public Fraction divide(Fraction f){
		return new Fraction(nu * f.de, de * f.nu);
	}

	/**divide*/
	public Fraction divide(int value){
		return divide(new Fraction(value, 1));
	}

	/**return in decimal form*/
	public double toDecimal(){
		return (double)nu / de;
	}

	/**return in a fractional string*/
	@Override
	public String toString(){
		String str = nu * de >=0 ? "" : "-";
		int nuu = Math.abs(nu);
		int dee = Math.abs(de);
		int integer = nuu / dee;
		int frac = nuu % dee;
		return str + (frac == 0 ? integer : (integer == 0 ? "" : integer + " ") + frac + "/" + dee);
	}

	/**Compute greatest common divisor of a and b*/
	private static int greatestCommonDivisor(int a, int b){
		int c;
		while(b != 0){
			c=a%b;
			a=b;
			b=c;
		}
		return a;
	}
}