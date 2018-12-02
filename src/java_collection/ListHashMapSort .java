import java.util.*;

public class ListHashMapSort {
    static final int SIZE = 3;
    public static void listHashMapSort(){
        List<HashMap<String,Object>> list = new ArrayList<>();
        for(int i=1;i<=SIZE;i++){
            HashMap<String,Object> hp = new HashMap<>();
            hp.put("科目"+i,"科目" + i);
            hp.put("分数",(int)(Math.random()*100));
            list.add(hp);
        }
        System.out.print("排序前：\n" + list);
        Collections.sort(list, new Comparator<HashMap<String, Object>>() {
            @Override
            public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
                Integer score1 = (Integer)o1.get("分数");
                Integer score2 = (Integer)o2.get("分数");
                //return score2.compareTo(score1);//升序
                return score2.compareTo(score1);//降序
            }
        });
        System.out.print("\n排序后：\n" + list);
    }
}
