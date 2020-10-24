package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;




   
public  class Readproperty {
	
	public static Properties UserData = 
			LoadProperties(System.getProperty(("user.dir")+"\\src\\test\\java\\configuration\\config.properties"));
	
	public static  Properties LoadProperties(String path)
	{
		Properties pro=new Properties();
		try {
			FileInputStream stream=new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			
			System.out.println("Error :" +e.getMessage());
		} catch (IOException e) {
			
			System.out.println("Error :" +e.getMessage());
		}
		return pro;
	}

}
