import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class SQLiteConnection {

	//static Connection conn = null;
	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:EmployeeDB.db");
			
			JOptionPane.showMessageDialog(null, "Connection Sucesfully Established");
			return conn;
			
		} catch (Exception e) {
			// TODO: handle exception
			
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
