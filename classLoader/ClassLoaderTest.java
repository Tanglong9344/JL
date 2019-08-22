import java.net.URL;

public class ClassLoaderTest {
    public static void main(String[] args ) {
       ClassLoader cl = ClassLoaderTest.class.getClassLoader();
       while (cl!=null){
           System.out.println(cl.getClass());
           cl=cl.getParent();
       }
       
       // 查看BootStrap已加载的所有类库
       URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
       for (java.net.URL url : urLs) {
           System.out.println(url.toExternalForm()) ;
       }
    }
}
