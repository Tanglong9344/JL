import java.util.*;

public class LinkedHashMapTraverse {
    static final int SIZE = 10;
    public static void linkedHashMapTraverse(){
        LinkedHashMap<String,Object> linkedHashMap = new LinkedHashMap<>();
        for(int i=1;i<=SIZE;i++){
          linkedHashMap.put("k"+i,"V"+i);
        }
        //遍历
        Iterator iterator = linkedHashMap.entrySet().iterator();
        System.out.print("[");
        while (iterator.hasNext()){
            Map.Entry kv = (Map.Entry)iterator.next();
            System.out.print(kv.getKey() + ":" + kv.getValue() + ",");
        }
        System.out.println("]");
    }
}
