package java_dynamic_compile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * A method like eval in the javascript
 *
 * @author Ã∆¡˙
 *
 */
public class EvalMethod {
	public static void main(String[] args) {
		EvalMethod.eval("Hello Eval");
	}
	public static void eval(String str) {
		// define a class
		StringBuilder sb = new StringBuilder("class Temp{\n");
		sb.append("\tpublic static String call(String[] ss) {\n");
		sb.append("\t\tSystem.out.println(\"" + str + "\");\n");
		sb.append("\t\treturn \"return str\";\n");
		sb.append("\t}\n");
		sb.append("}");

		// write string to a file
		try {
			File f = new File("src/java_dynamic_compile/eval.txt");
			PrintWriter pw = new PrintWriter(new FileWriter(f));
			pw.println(sb.toString());
			pw.close();
		} catch(IOException e) {e.printStackTrace();}

		// dynamic compile
		JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
		int result = javaCompiler.run(null, null, null, "-d","/src/","/src/java_dynamic_compile/eval.txt");
		System.out.println( result == 0 ? "πßœ≤±‡“Î≥…π¶" : "±‡“Î ß∞‹");

		try {
			Class<?> clazz = Class.forName("Temp");
			try {
				Method call = clazz.getMethod("call", new Class[] {String[].class});
				try {
					call.invoke(null, new Object[] {new String[0]});
				}
				catch(IllegalArgumentException e1) {e1.printStackTrace();}
				catch(InvocationTargetException e2) {e2.printStackTrace();}
				catch(IllegalAccessException e3) {e3.printStackTrace();}
			} catch(NoSuchMethodException e) {e.printStackTrace();}
		} catch(ClassNotFoundException e) {e.printStackTrace();}
	}
}