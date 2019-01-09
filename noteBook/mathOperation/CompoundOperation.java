public class CompoundOperation {
    private static void test(){
        short x = 0;
        int i = 123456;
        x += i; // 包含了一个隐藏的转型(<==>x = (short)(x + i);)
    }
}
