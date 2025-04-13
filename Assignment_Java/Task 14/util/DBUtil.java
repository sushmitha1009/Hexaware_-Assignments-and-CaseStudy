package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getDBConn() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/HMBank";
        String username = "root";
        String password = "Sushmitha@10";
        return DriverManager.getConnection(url, username, password);
    }
}
