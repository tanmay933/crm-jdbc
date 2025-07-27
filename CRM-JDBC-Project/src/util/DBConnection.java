// DBConnection.java
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DBConnection {
    private static final String PROPERTIES_FILE = "/db.properties";

    public static Connection getConnection() throws SQLException {
        try (InputStream input = DBConnection.class.getResourceAsStream(PROPERTIES_FILE)) {
            Properties props = new Properties();
            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new SQLException("Failed to connect to DB", e);
        }
    }
}
