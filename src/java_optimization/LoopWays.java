package java_optimization;

import static java_optimization.CommonConstants.N;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Loop in three ways
 * 1. for loop(worst)
 * 2. enhanced for loop(second-best)
 * 3. for-each(second-worst)
 * 4. iterator(best)
 *
 * result: LoopWaysCost.txt
 *
 * @author ÌÆÁú
 *
 */
public class LoopWays {
	public static void main(String[] args) throws IOException {
		List<String> list = new ArrayList<String>();
		// Initialization List
		for(int i=1;i<=N;i++){
			list.add("V" + i);
		}
		File f = new File("src/java_optimization/LoopWaysCost.txt");
		FileWriter fw = new FileWriter(f);
		PrintWriter pw = new PrintWriter(fw);
		long start,end,avg;
		int i;
		// for loop
		avg = 0;
		for(i=0;i<N;i++){
			start = System.nanoTime();
			loopFor(list);
			end = System.nanoTime();
			avg += end-start;
		}
		pw.printf("For loop operates %d times averagely cost          %d ns%n", N, avg/N);

		// enhanced for loop
		avg = 0;
		for(i=0;i<N;i++){
			start = System.nanoTime();
			loopForEnhanced(list);
			end = System.nanoTime();
			avg += end-start;
		}
		pw.printf("Enhanced for loop operates %d times averagely cost %d ns%n", N, avg/N);

		// for-each loop
		avg = 0;
		for(i=0;i<N;i++){
			start = System.nanoTime();
			loopForEach(list);
			end = System.nanoTime();
			avg += end-start;
		}
		pw.printf("For-each loop operates %d times averagely cost     %d ns%n", N, avg/N);

		// iterator
		avg = 0;
		for(i=0;i<N;i++){
			start = System.nanoTime();
			loopIterator(list);
			end = System.nanoTime();
			avg += end-start;
		}
		pw.printf("Iterator operates %d times averagely cost          %d ns%n", N, avg/N);

		//close the file stream
		f.exists();
		fw.close();
		pw.close();
	}

	// for loop
	private static void loopFor(List<String> list){
		int len = list.size();
		for(int i=0;i<len;i++){
			System.out.print(list.get(i) + ",");
		}
		System.out.println();
	}

	// enhanced for loop
	private static void loopForEnhanced(List<String> list){
		for(String str : list){
			System.out.print(str + ",");
		}
		System.out.println();
	}

	// for-each loop
	private static void loopForEach(List<String> list){
		list.forEach(s->System.out.print(s + ","));
		System.out.println();
	}

	// Iterator
	private static void loopIterator(List<String> list){
		for(Iterator<String> i = list.iterator();i.hasNext();) {
			System.out.print(i.next() + ",");
		}
		System.out.println();
	}
}