package java_other;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Script Engine in Java
 * 
 * @author ÌÆÁú
 *
 */
public class ScriptEngineTest {
	public static void main(String[] args) throws ScriptException {
		double result;
		ScriptEngineManager manager = new ScriptEngineManager();

		// name
		ScriptEngine se = manager.getEngineByName("javascript");
		result = (int) se.eval("2*3");
		System.out.println(result);

		// extension-name
		ScriptEngine se2 = manager.getEngineByExtension("js");
		result = (int) se2.eval("2+3");
		System.out.println(result);

		// mime-type
		ScriptEngine se3 = manager.getEngineByMimeType("text/javascript");
		result = (double) se3.eval("2/3");
		System.out.println(result);
	}
}