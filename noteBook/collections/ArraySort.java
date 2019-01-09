import java.util.Arrays;
import java.util.Comparator;

public class ArraySort {
    private static void sortways(){
        Integer[] array = { 3, 1, 4, 1, 5, 9 };
        // Comparator方式
        Arrays.sort(array, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i1 < i2 ? -1 : 1;
            }
        });
        // lamdab方式
        Arrays.sort(array, (Integer i1, Integer i2)->i1.compareTo(i2));
    }
}
