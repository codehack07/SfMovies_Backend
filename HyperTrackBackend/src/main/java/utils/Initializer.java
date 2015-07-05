package main.java.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Initializer {

	static public Properties properties = null;

	public Initializer(){
		super();
		try {
			InputStream isr = this.getClass().getClassLoader().getResourceAsStream("errorCodes.properties");
			//InputStream isr = Thread.currentThread().getContextClassLoader().getResourceAsStream("errorCodes.properties");
			//properties.load(MyClass.class.getResourceAsStream("/config.properties"));
		//	InputStream isr = loader.getResourceAsStream"src/main/resources/errorCodes.properties");
		properties = new Properties();
			properties.load(isr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}