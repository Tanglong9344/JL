import java.util.Arrays;
import java.util.List;

public class ArrayToListTest {
    public static void main(String[] args) {
        String[] arr = new String[]{"Hello","Array","List"};
        // 适配器模式
        List<String> list = Arrays.asList(arr);
        list.forEach(e->System.out.print(e + ","));
    }
}
