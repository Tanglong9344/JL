public class LongCompare {
    public static void longCompare(){
        long val1 = 128;
        long val2 = 128;

        Long val3 = -129L;
        Long val4 = -129L;


        System.out.print("val1==val2: ");
        System.out.println(val1 == val2);//true

        System.out.print("val3==val4: ");
        System.out.println(val3 == val4);//false
        // (如果-128<=数值<=127,结果是true，原因参见java.lang.Long 的LongCache)

        System.out.print("val3.equals(val4): ");
        System.out.println(val3.equals(val4));//true

        System.out.print("val3.longValue() == val4.longValue(): ");
        System.out.println(val3.longValue() == val4.longValue());//true
    }
}
