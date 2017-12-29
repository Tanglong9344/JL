package java_web_programming;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Url information
 *
 * @author ����
 *
 */
public class NetUrl {
	public static void main(String[] args){
		for(int i=0;i<2;i++){
			try {
				String urlStr = "http://www.helloWorld"+String.valueOf(i+1) +".com:"+String.valueOf(i+1)+"?userName=name"+String.valueOf(i+1);
				URL url = new URL(urlStr);
				System.out.println("URL�ĵ�ַ�ǣ� " + url);
				System.out.println("URL��Э���ǣ� " + url.getProtocol());
				System.out.println("�û���Ϣ�ǣ� " + url.getUserInfo());
				String s = url.getHost();
				if(s!=null){
					int it = s.indexOf('@');
					if(it!=-1){
						s= s.substring(it+1);
						System.out.println(s);
					}
				}else{
					System.out.println(args[i]+"����Ϊ�գ�");
				}
				System.out.println("�˿��ǣ�"+url.getPort());
				System.out.println("·���ǣ�"+url.getPath());
				System.out.println("�ļ������ǣ�"+url.getFile());
				System.out.println("�������ǣ�"+url.getHost());
			} catch (MalformedURLException e) {
				System.out.println("����һ��URL��ַ��");
			}
		}
	}
}