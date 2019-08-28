import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListRemoveTest {
        public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            list.add("1");
            list.add("2");
            printList(list);
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String item = iterator.next();
                if ("2".equals(item)) {
                    iterator.remove();
                }
            }
//            for (String item : list){
//                if ("2".equals(item)) {
//                    list.remove(item);
//                }
//            }
            printList(list);
        }

        /** 遍历List */
        private static <T> void printList (List<T> list){
            if (list !=null && list.size()>0){
                if (list.get(0) instanceof String){
                    System.out.println("字符串:");
                }
                list.forEach(e->System.out.print(e + ","));
                System.out.println("");
            }
        }
}
