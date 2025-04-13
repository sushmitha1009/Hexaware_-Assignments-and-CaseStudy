package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    public static String getConnectionString(String fileName) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            properties.load(fis);
        }
        return properties.getProperty("db.connection.string");
    }
}
