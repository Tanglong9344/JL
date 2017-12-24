package java_enum;

public class EnumMethod {
	public static void main(String[] args) {
		System.out.println("--------------Month--------------");
		for(Month m : Month.values()){
			System.out.printf("The Days of %9s : %d%n", m.name(), m.getDays());
		}

		System.out.println("--------------Season--------------");
		for(Seasons s : Seasons.values()){
			System.out.printf("The Days of %6s : %d%n", s.name(), s.getDays());
		}
	}
}

/**Four Seasons*/
enum Seasons{
	SPRING(Month.MARCH),
	SUMMER(Month.JUNE),
	AUTUMN(Month.SEPTEMBER),
	WINTER(Month.DECEMBER);

	private int days = 0;
	private final Month[] MONYHS = Month.values();

	/**Constructor*/
	Seasons(Month startMonth){
		for(int i=0,num = startMonth.ordinal();i<3;i++){
			if(num>11){num = 1;}
			days += MONYHS[num].getDays();
			num++;
		}
	}

	/**return days of each season*/
	public int getDays(){return days;}
}

/**Months*/
enum Month{
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
	Month(int days){
		this.days = days;
	}

	/**return days of each month*/
	public int getDays(){return days;}
}