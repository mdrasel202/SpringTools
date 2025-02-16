package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	static final String URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";
	static final String USER = "orclpdbuser";
	static final String PASSWORD = "isdb62";

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Oracle JDBC Drive not found.");
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
