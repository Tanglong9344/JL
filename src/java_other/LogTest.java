package java_other;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogTest {
	//This is a test
	public static void main(String[] args) {
		LogTest lt = new LogTest();
		lt.loggerTest("Logger");
	}
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public void loggerTest(String name){
		//logger.log(Level.FINE, name+"----��(FINE)", "");
		//logger.log(Level.FINER, name+"----�ܺ�(FINER)", "");
		//logger.log(Level.FINEST, name+"----�ü���(FINEST)", "");
		logger.log(Level.INFO, name+"----��Ϣ(INFO)", "");
		//logger.log(Level.CONFIG, name+"----����(CONFIG)", "");
		//logger.log(Level.WARNING, name+"----����(WARNING)", "");
		//logger.log(Level.SEVERE, name+"----����(SEVERE)", "");
		//logger.log(Level.OFF, name+"----����(OFF)", "");
		//logger.log(Level.ALL, name+"----ȫ��(All)", "");
	}
}