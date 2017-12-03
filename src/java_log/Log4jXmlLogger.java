package java_log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jXmlLogger {
	static Logger logger = Logger.getLogger(Log4jXmlLogger.class);
	public static void main(String[] args) throws InterruptedException {
		PropertyConfigurator.configure("src/java_log/log4j.xml");
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