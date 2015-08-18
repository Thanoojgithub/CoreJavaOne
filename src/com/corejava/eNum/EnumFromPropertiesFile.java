package com.corejava.eNum;

import java.util.Properties;
import java.util.logging.Logger;

public class EnumFromPropertiesFile {

	public static void main(String[] args) {
		System.out.println(Constants.NAME.getValue());
		System.out.println(Constants.LOC.getValue());
	}
}

enum Constants {
	NAME, LOC;

	private static final String PATH = "constants.properties";
	private static final Logger LOG = Logger.getLogger("Constants");
	private static Properties properties;
	private String value;

	private void init() {
		if (properties == null) {
			properties = new Properties();
			try {
				properties.load(Constants.class.getResourceAsStream(PATH));
			} catch (Exception e) {
				LOG.info("Unable to load " + PATH + " file from classpath." + e);
				System.exit(1);
			}
		}
		value = (String) properties.get(this.toString());
	}

	public String getValue() {
		if (value == null) {
			init();
		}
		return value;
	}
}



/*simple enum to-be used
 * 
 * 
 * enum Shap {
 * 
 * CIRCLE("CIRCLE"), RECTANGLE("RECTANGLE"), SQUARE("SQUARE"); 
 * public final String value;
 * 
 * private Shap(String value) {
 *  this.value = value; 
 * } 
 * }
 */
