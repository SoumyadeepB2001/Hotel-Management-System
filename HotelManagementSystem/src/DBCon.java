import java.sql.*;

public class DBCon {
	Connection c;
	Statement s;

	DBCon() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3308/project", "root", "");
			s = c.createStatement();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}