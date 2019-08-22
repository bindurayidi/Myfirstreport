package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	public String pValue;
	public String configPathLocation="C:\\Users\\bindu\\eclipse-workspace\\catalog\\src\\main\\java\\config\\config.properties";
    
	public String readfile(String File,String pName) {
		try {
			
			Properties prop=new Properties();
			FileInputStream in=new FileInputStream(File);
			prop.load(in);
			pValue=prop.getProperty(pName);
			System.out.println("value is:"+pValue);
			return pValue;
		}catch(IOException e) {
			System.out.println("Error is:"+e.getMessage());
			e.printStackTrace();
		}
		return pValue;
			
        }
	 public  String getConfigPropertyVal(final String key) {
		    String ConfigPropertyVal = readfile(configPathLocation,key);
			return ConfigPropertyVal != null ? ConfigPropertyVal.trim() : ConfigPropertyVal;
		}
		
	
}
