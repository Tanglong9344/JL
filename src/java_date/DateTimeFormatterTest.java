import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;

public class DateTimeFormatterTest {
    private static final int LOOP_TIMES = 10;
    public static void main(String[] args) {
        dateFormatCompare(2,LOOP_TIMES);
        dateFormatCompare(1,LOOP_TIMES);
    }

    /** 日期格式化比较
     * type：
     * 1：SimpleDateFormat
     * 2：DateTimeFormatter
     * */
    private static void dateFormatCompare(int type,int loopTimes){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        long startTime,endTime;
        startTime = System.currentTimeMillis();
        if(type == 1){
            Date date = new Date();
            for(int i = 0;i < loopTimes; i++){
                sdf.format(date);
            }
        } else{
            LocalDate localDate = LocalDate.now();
            for(int i = 0;i < loopTimes; i++){
                dtf.format(localDate);
            }
        }
        endTime = System.currentTimeMillis();
        String str = type == 1 ? "SimpleDateFormat" : "DateTimeFormatter";
        System.out.println(str + "用时:" + (endTime - startTime) + "ms");
    }
}
