import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class InstantTest {
    public static void main(String[] args){
        // date to Instant
        Instant now  = new Date().toInstant();
        System.out.println("now:" + now);

        // 默认UTC时区
        Instant nowUTC  = Instant.now();
        System.out.println("nowUTC:" + nowUTC);

        // +8h
        Instant nowBeijing  = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        System.out.println("nowBeijing:" + nowBeijing);
        System.out.println("秒数:" + nowBeijing.getEpochSecond());
        System.out.println("毫秒数:" + nowBeijing.toEpochMilli());

        // 选择系统时区
        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.systemDefault());
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("datetime:" + zonedDateTime);
        System.out.println("day of month:" + zonedDateTime.getDayOfMonth());
        System.out.println("day of week:" + zonedDateTime.getDayOfWeek());

        System.out.println("zone:" + zonedDateTime.getZone());
        System.out.println("year:" + zonedDateTime.getYear());
        System.out.println("month:" + zonedDateTime.getMonth());
        System.out.println("hour:" + zonedDateTime.getHour());
        System.out.println("minute:" + zonedDateTime.getMinute());
        System.out.println("second:" + zonedDateTime.getSecond());
        System.out.println("nano:" + zonedDateTime.getNano());
        System.out.println("格式化:" + zonedDateTime.format(dtf));
    }
}
