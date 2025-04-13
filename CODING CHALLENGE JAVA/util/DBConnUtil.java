package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
    public static Connection getDBConn(String connectionString) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            return DriverManager.getConnection(connectionString);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Database connection failed", e);
        }
    }
}
