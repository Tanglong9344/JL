public class EnumTest {
    public static void main(String[] args){
        for(SeasonEnum season:SeasonEnum.values()){
            System.out.println(season + ":" + season.getSeq());
        }
    }
}
 enum SeasonEnum {
    SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);
    private int seq;

    SeasonEnum(int seq) {
        this.seq = seq;
    }

    public int getSeq() {
        return seq;
    }
}
