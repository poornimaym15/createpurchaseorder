package com.crm.comcast.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * Utility for property file
 * @author POORNIMA
 *
 */
 
public class FileUtility { 
	/**
	 * this method will fetch the data from property file based on the key passed
	 * @parent key
	 * @return
	 * @throws Throwable
	 * 
	 */

	
public String getPropertyFileData(String key) throws Throwable {
FileInputStream file = new FileInputStream(IPathConstants.PROPERTYFILEPATH);	
 Properties property= new Properties();
 property.load(file);
 return property.getProperty(key);

	
	
}
}
