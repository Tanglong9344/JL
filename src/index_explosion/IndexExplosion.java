package index_explosion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ָ����ը����-�Ӽ�С������
 *
 * @author ����
 *
 */
public class IndexExplosion {
	public static void main(String[] args) throws IOException {
		double x = Double.MAX_VALUE;
		int count = 0;
		File f = new File("src/index_explosion/result.txt");
		PrintWriter pw = new PrintWriter(new FileWriter(f));
		while((1/(2*x)) != Double.POSITIVE_INFINITY){
			pw.println((1/x));
			pw.flush();
			x /= 2;
			count ++;
		}
		pw.close();
		// count all the times of operation
		System.out.println("Count: " + count);
	}
}