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
		
		
		ChinookDatabase db = new ChinookDatabase();
		Connection connection = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			statement = connection.prepareStatement("SELECT * FROM Album LEFT JOIN Artist ON Artist.ArtistId = Album.ArtistId ORDER BY Title ASC");
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
	
	public List<Album> findAlbumByArtist(String artistid) {
		ChinookDatabase db = new ChinookDatabase();
        Connection connection = db.connect();
        PreparedStatement statement = null;
        ResultSet results = null;
        ArrayList<Album> list = new ArrayList<>();
       
        
        
        try {
            statement = connection.prepareStatement("SELECT *, Artist.Name FROM Album LEFT JOIN Artist ON Artist.ArtistId = Album.ArtistId WHERE Album.ArtistId = ?");
            statement.setLong(1, Long.parseLong(artistid));
            results = statement.executeQuery();
        
            while (results.next()) {
            	Long albumid = results.getLong("AlbumId");
                String title = results.getString("Title");
                String albumArtist = results.getString("Name");
                Album album = new Album(albumid, title, albumArtist);
               
                list.add(album);
            } 
           
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.close(results, statement, connection);
        }  return list;
    }

}
