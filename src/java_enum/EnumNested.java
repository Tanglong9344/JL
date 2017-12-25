package java_enum;

/**
 * Nested enum(Strategy enum)
 *
 * @author ÌÆÁú
 *
 */
public class EnumNested {
	public static void main(String[] args) {
		System.out.println("--------------Season--------------");
		for(Seasons s : Seasons.values()){
			System.out.printf("The Days of %6s : %d%n", s.name(), s.getDays());
		}
	}
}

/**Four Seasons*/
enum Seasons{
	SPRING(Months.MARCH),
	SUMMER(Months.JUNE),
	AUTUMN(Months.SEPTEMBER),
	WINTER(Months.DECEMBER);

	private int days = 0;
	private final Months[] MONYHS = Months.values();

	/**Constructor*/
	Seasons(Months startMonth){
		for(int i=0,num = startMonth.ordinal();i<3;i++){
			if(num>11){num = 1;}
			days += MONYHS[num].getDays();
			num++;
		}
	}

	/**return days of each season*/
	public int getDays(){return days;}

	/**Inner enum-Months*/
	private enum Months{
		JANUARY(31),
		FEBRUARY(29),
		MARCH(31),
		APRIL(30),
		MAY(31),
		JUNE(30),
		JULY(31),
		AUGUST(31),
		SEPTEMBER(30),
		OCTOBER(31),
		NOVEMBER(30),
		DECEMBER(31);

		private final int days;

		/**Constructor*/
		Months(int days){
			this.days = days;
		}

		/**return days of each month*/
		public int getDays(){return days;}
	}
}