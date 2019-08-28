import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListToArrayTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("List");
        list.add("array");

        // toArray()只能得到Object[]
        Object[] arr1 = list.toArray();
        for(Object obj:arr1){
            System.out.println(obj.toString());
        }
        System.out.println("---------");
        // toArray(param)且param的length=0,性能最好
        String[] arr2 = list.toArray(new String[0]);
        for(String str:arr2){
            System.out.println(str);
        }
    }
}
