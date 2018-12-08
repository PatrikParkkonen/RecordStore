package recordstore.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import recordstore.database.ChinookDatabase;

public class PrintAlbums {

	public static void main(String[] args) throws SQLException {
		
		String SQL = "Select * FROM Album WHERE ArtistId = (SELECT ArtistId FROM Artist WHERE Name = ?)";

		ChinookDatabase db = new ChinookDatabase();

		Connection connection = db.connect();

		PreparedStatement statement = connection.prepareStatement(SQL);
		
		//Put Scanner here
		
		String input = "AC/DC";
		
		statement.setString(1, input);

		ResultSet results = statement.executeQuery();

		while (results.next()) {

			String title = results.getString("Title");

			System.out.println(title);
		}
		
		db.close(results, statement, connection);
		
	}

}
