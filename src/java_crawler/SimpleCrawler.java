package java_crawler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple Crawler: download picture from baidu
 *
 * It is just feasible to http://www.baidu.com
 *
 * @author ����
 *
 */
public class SimpleCrawler {
	static String http;
	public static void main(String[] args) throws IOException{
		String url = "http://www.baidu.com";
		http = url.split(":")[0] + "://www";

		// get result from url
		String result = urlResult(url);

		// write data into a html file
		String fileHtml = "src/java_crawler/baidu.html";
		fileIn(fileHtml,result);

		// write data into a txt file
		String fileTxt = "src/java_crawler/baidu.txt";
		fileIn(fileTxt,result);

		// get image url
		String regex = "src=.*>";
		List<String> urList = regExpStr(regex, result);

		// download and save picture
		String path = "src/java_crawler/";
		for(int i=0,len=urList.size();i<len;i++) {
			String str = urList.get(i);
			String urlp = str.substring(str.indexOf('.'), str.lastIndexOf('.'));
			pictureDownload(http + urlp + ".png",path + i + ".png");
		}
	}

	/**Get result according to url*/
	private static String urlResult(String urlStr) {
		// �洢��ҳ����
		StringBuilder sb = new StringBuilder();
		// �����ַ�������
		BufferedReader in = null;
		try {
			// ��stringת��url����
			URL url = new URL(urlStr);
			// ��ʼ����url������
			URLConnection connection = url.openConnection();
			// ����
			connection.connect();
			// ��ʼ�� BufferedReader����������ȡURL����Ӧ�������ʽ��utf-8��
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
			// ������ʱ�洢ץȡ����ÿһ�е�����
			String line = null;
			while ((line = in.readLine()) != null) {
				sb.append(line);//����ץȡ����ÿһ�����ݲ����д洢
			}
		} catch (Exception e) {
			System.out.println("����GET��������쳣��" + e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("Get html success...");
		return sb.toString().replaceAll(">", ">\n"); // format the result
	}

	/**
	 * file write
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 * */
	private static void fileIn(String fileName, String result) throws FileNotFoundException, UnsupportedEncodingException {
		String encode = fileName.split("\\.")[1].equals("html")? "utf-8":"gbk";
		FileOutputStream fos   = new FileOutputStream(fileName);
		OutputStreamWriter osw = new OutputStreamWriter(fos,encode);
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(osw));) {
			pw.println(result.toString());
			pw.flush();//ˢ�»���
		}
	}

	/**
	 * Get image urls
	 *
	 * @param regex
	 * @param result
	 * @return
	 */
	private static List<String> regExpStr(String regex, String result) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(result);
		List<String> list = new ArrayList<String>();
		if(m.find()) {
			list.add(m.group(0));
		}
		System.out.println("Get image url success...");
		return list;
	}

	/**
	 * Download pictures from urls and save them
	 *
	 * @param urlStr
	 * @param dir
	 * @throws IOException
	 */
	private static void pictureDownload(String urlStr,String path) throws IOException {
		URL url = null;
		DataInputStream dis        = null;
		FileOutputStream fos       = null;
		ByteArrayOutputStream baos = null;
		try {
			url  = new URL(urlStr);
			dis  = new DataInputStream(url.openStream());
			fos  = new FileOutputStream(new File(path));
			baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int length;
			while ((length = dis.read(buffer)) > 0) {
				baos.write(buffer, 0, length);
			}
			fos.write(baos.toByteArray());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(dis != null) {
				dis.close();
			}
			if(fos != null) {
				fos.close();
			}
			if(baos != null) {
				baos.close();
			}
		}
		System.out.println("Picture download success...");
	}
}