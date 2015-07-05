package main.java.logging;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class AppLog {

	static{
		PropertyConfigurator.configure("E:/HouseKeepings/housekeepings-backend/src/main/resources/log4j.properties");
	}
	
    public static void debug(String message, Class<?> clazz){
    	Logger log = Logger.getLogger(clazz.getName());
		log.debug(message);
    }
    
    public static void info(String message, Class<?> clazz){
    	Logger log = Logger.getLogger(clazz.getName());
		log.info(message);
    }
    
    public static void trace(String message, Class<?> clazz){
    	Logger log = Logger.getLogger(clazz.getName());
		log.trace(message);
    }
    
    public static void warn(String message, Class<?> clazz){
    	Logger log = Logger.getLogger(clazz.getName());
		log.warn(message);
    }
    
    public static void error(String message, Class<?> clazz){
    	Logger log = Logger.getLogger(clazz.getName());
		log.error(message);
    }
    
}