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
		//logger.log(Level.FINE, name+"----好(FINE)", "");
		//logger.log(Level.FINER, name+"----很好(FINER)", "");
		//logger.log(Level.FINEST, name+"----好极了(FINEST)", "");
		logger.log(Level.INFO, name+"----信息(INFO)", "");
		//logger.log(Level.CONFIG, name+"----配置(CONFIG)", "");
		//logger.log(Level.WARNING, name+"----警告(WARNING)", "");
		//logger.log(Level.SEVERE, name+"----严重(SEVERE)", "");
		//logger.log(Level.OFF, name+"----禁用(OFF)", "");
		//logger.log(Level.ALL, name+"----全部(All)", "");
	}
}