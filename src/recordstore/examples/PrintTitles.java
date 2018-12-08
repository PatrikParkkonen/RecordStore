package recordstore.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import recordstore.database.ChinookDatabase;

public class PrintTitles {

	public static void main(String[] args) throws SQLException {

		ChinookDatabase db = new ChinookDatabase();

		Connection connection = db.connect();

		PreparedStatement statement = connection.prepareStatement("Select * FROM Album ORDER By Title ASC");

		ResultSet results = statement.executeQuery();

		while (results.next()) {

			String title = results.getString("Title");

			System.out.println(title);
		}
		
		db.close(results, statement, connection);
		
	}

}
