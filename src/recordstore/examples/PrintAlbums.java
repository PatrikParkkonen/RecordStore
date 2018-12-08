package recordstore.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import recordstore.database.ChinookDatabase;

public class PrintAlbums {

	public static void main(String[] args) throws SQLException {
		
		String SQL = "Select * FROM Album WHERE ArtistId = (SELECT ArtistId FROM Artist WHERE Name = ?)";

		ChinookDatabase db = new ChinookDatabase();

		Connection connection = db.connect();

		PreparedStatement statement = connection.prepareStatement(SQL);
		
		Scanner lukija = new Scanner(System.in);
    	
    	System.out.println("Anna artistin nimi: ");
    	 String input = lukija.next();
		
		statement.setString(1, input);

		ResultSet results = statement.executeQuery();

		while (results.next()) {

			String title = results.getString("Title");

			System.out.println(title);
		}
		
		db.close(results, statement, connection);
		
	}

}
