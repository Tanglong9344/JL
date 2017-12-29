package java_web_programming;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Url information
 *
 * @author 唐龙
 *
 */
public class NetUrl {
	public static void main(String[] args){
		for(int i=0;i<2;i++){
			try {
				String urlStr = "http://www.helloWorld"+String.valueOf(i+1) +".com:"+String.valueOf(i+1)+"?userName=name"+String.valueOf(i+1);
				URL url = new URL(urlStr);
				System.out.println("URL的地址是： " + url);
				System.out.println("URL的协议是： " + url.getProtocol());
				System.out.println("用户信息是： " + url.getUserInfo());
				String s = url.getHost();
				if(s!=null){
					int it = s.indexOf('@');
					if(it!=-1){
						s= s.substring(it+1);
						System.out.println(s);
					}
				}else{
					System.out.println(args[i]+"域名为空！");
				}
				System.out.println("端口是："+url.getPort());
				System.out.println("路径是："+url.getPath());
				System.out.println("文件类型是："+url.getFile());
				System.out.println("主机名是："+url.getHost());
			} catch (MalformedURLException e) {
				System.out.println("不是一个URL地址！");
			}
		}
	}
}