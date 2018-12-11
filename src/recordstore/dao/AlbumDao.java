package recordstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import recordstore.database.ChinookDatabase;
import recordstore.models.Album;
import recordstore.models.Artist;


public class AlbumDao {
	
	public List<Album> getAllAlbums() {
		 ArrayList<Album> list = new ArrayList<>();
		
		// Kootaan kaikki artistit
		ChinookDatabase db = new ChinookDatabase();
		Connection connection = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			statement = connection.prepareStatement("SELECT * FROM Album ORDER BY Title ASC");
			results = statement.executeQuery();
			
			while (results.next()) {
				long id = results.getLong("AlbumId");
				String title = results.getString("Title");
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
                String title = results.getString("Title");
                Album album = new Album(id, title);
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
	
	public List<Album> findAlbumByArtist(Artist artist) {
		ChinookDatabase db = new ChinookDatabase();
        Connection connection = db.connect();
        PreparedStatement statement = null;
        ResultSet results = null;
        ArrayList<Album> list = new ArrayList<>();
        long artistid = artist.getId();
        
        try {
            statement = connection.prepareStatement("SELECT * FROM Album LEFT JOIN Artist ON Artist.ArtistId = Album.ArtistId WHERE Artist.ArtistId = ?");
            statement.setLong(1, artistid);
            results = statement.executeQuery();

            while (results.next()) {
            	Long albumid = results.getLong("AlbumId");
                String title = results.getString("Title");
                Album album = new Album(albumid, title);
                list.add(album);
            } 
            return list;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.close(results, statement, connection);
        }
    }

}
