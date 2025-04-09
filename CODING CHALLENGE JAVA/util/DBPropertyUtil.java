package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    private static final String PROPERTY_FILE = "C:\\Users\\S.Kavitha\\Documents\\LoanManagementSystem\\src\\resources\\db.properties";

    public static Properties getDBProperties() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTY_FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("Error loading database properties: " + e.getMessage());
        }
        return properties;
    }
}
