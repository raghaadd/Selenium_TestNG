package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	
	private static Logger logger=LogManager.getLogger(Log4jDemo.class);

	public static void main(String[] args) {
		System.out.println("\nHello World...  \n");
		
		logger.trace("This is a trace message");
		logger.info("This is an information message");
		logger.error("This is an error message");
		logger.warn("This a warning message");
		logger.fatal("This is a fetal message");
		
		System.out.println("\nCompleted");
		

	}

}
