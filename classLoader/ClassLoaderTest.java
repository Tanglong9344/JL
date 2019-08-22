public class ClassLoaderTest {
    public static void main(String[] args ) {
       ClassLoader cl = ClassLoaderTest.class.getClassLoader();
       while (cl!=null){
           System.out.println(cl.getClass());
           cl=cl.getParent();
       }
    }
}
