import java.util.Random;

public class RandomChar {
    public static  void random1(){
        Random random = new Random();
        System.out.println("THW".charAt(random.nextInt(3)) + "a");
    }
}
