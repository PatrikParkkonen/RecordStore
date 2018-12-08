package recordstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import recordstore.database.ChinookDatabase;
import recordstore.models.Album;


public class AlbumDao {
	
	public List<Album> getAllAlbums() {
		 ArrayList<Album> list = new ArrayList<>();
		
		// Kootaan kaikki artistit
		ChinookDatabase db = new ChinookDatabase();
		Connection connection = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			statement = connection.prepareStatement("SELECT * FROM Album ORDER BY Name ASC");
			results = statement.executeQuery();
			
			while (results.next()) {
				long id = results.getLong("AlbumId");
				String name = results.getString("Title");
				list.add(new Album(id, title));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		db.close(results, statement, connection);
		
		return list;
	}
	
	public Album findAlbum(long id) {
		ChinookDatabase db = new ChinookDatabase();
        Connection connection = db.connect();
        PreparedStatement statement = null;
        ResultSet results = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM Album WHERE AlbumId = ?");
            statement.setLong(1, id);
            results = statement.executeQuery();

            if (results.next()) {
                String name = results.getString("Title");
                Album album = new Album(id, name);
                return album;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.close(results, statement, connection);
        }
    }

}
