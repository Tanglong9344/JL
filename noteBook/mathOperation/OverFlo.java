public class OverFlow {
    /** 每一个因子都是int，最后的乘积溢出 */
    private static void overflow(){
        final long MICROSECOND_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MILLISECOND_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MICROSECOND_PER_DAY/MILLISECOND_PER_DAY);
    }

    /** 将第一个因子设为long */
    private static void noOverflow(){
        final long MICROSECOND_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
        final long MILLISECOND_PER_DAY = 24L * 60 * 60 * 1000;
        System.out.println(MICROSECOND_PER_DAY/MILLISECOND_PER_DAY);
    }
}
