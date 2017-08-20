package java_log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jTest {
	static Logger logger = Logger.getLogger(Log4jTest.class);
	public static void main(String[] args) throws InterruptedException {
		PropertyConfigurator.configure("d:\\workplace\\JavaScoreBasic\\log4j.properties");
		for (int i = 0; i < 5; i++) {
			logger.trace("������Ϣ");
			logger.debug("������Ϣ");
			logger.info("�����Ϣ");
			logger.warn("������Ϣ");
			logger.error("������Ϣ");
			logger.fatal("������Ϣ");
		}
	}
}