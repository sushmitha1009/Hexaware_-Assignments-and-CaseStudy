package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    public static String getPropertyString() throws IOException {
        FileInputStream fis=new FileInputStream("db.properties");
        Properties properties=new Properties();
        properties.load(fis);
        String hostname=properties.getProperty("db.hostname");
        String port=properties.getProperty("db.port");
        String dbname=properties.getProperty("db.dbname");
        String connectionUrl="jdbc:mysql://"+hostname+":"+port+"/"+dbname;
        return connectionUrl;
    }
}
