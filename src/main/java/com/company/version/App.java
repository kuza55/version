package com.company.version;

import java.io.InputStream;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static String getVersion() throws Exception {
		//Load version data, as per
        //http://blog.soebes.de/blog/2014/01/02/version-information-into-your-appas-with-maven/
        InputStream resourceAsStream =
                App.class.getResourceAsStream(
                  "/META-INF/maven/com.company/version/pom.properties"
                );
		Properties pomProperties = new Properties();
		pomProperties.load( resourceAsStream );
		
		String version = pomProperties.getProperty("version");
		Integer snapshotIdx = version.lastIndexOf("-SNAPSHOT");
		if (snapshotIdx >= 0) {
			version = version.substring(0, snapshotIdx);
		}
		
		return version;
	}
	
    public static void main( String[] args ) throws Exception
    {
        
		
		System.out.println("Hello version " + getVersion());
    }
}
