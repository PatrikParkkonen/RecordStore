package recordstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import recordstore.database.ChinookDatabase;
import recordstore.models.Album;
import recordstore.models.Track;

public class TrackDao {
	
	public List<Track> getAllTracks() {
		 ArrayList<Track> list = new ArrayList<>();
		
		
		ChinookDatabase db = new ChinookDatabase();
		Connection connection = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			statement = connection.prepareStatement("SELECT * FROM Track ORDER BY Name ASC");
			results = statement.executeQuery();
			
			while (results.next()) {
				long id = results.getLong("TrackId");
				String name = results.getString("Name");
				long mediatypeid = results.getLong("MediatypeId");
				long genreid = results.getLong("GenreId");
				String composer = results.getString("Composer");
				long milliseconds = results.getLong("Milliseconds");
				long bytes = results.getLong("Bytes");
				double unitprice = results.getDouble("Unitprice");
				
				
				list.add(new Track(id, name, mediatypeid, genreid, composer, milliseconds, bytes, unitprice));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		db.close(results, statement, connection);
		
		return list;
	}
	
	public Track findTrack(long id) {
		ChinookDatabase db = new ChinookDatabase();
        Connection connection = db.connect();
        PreparedStatement statement = null;
        ResultSet results = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM Track WHERE ArtistId = ?");
            statement.setLong(1, id);
            results = statement.executeQuery();

            if (results.next()) {
                String name = results.getString("Name");
                Track track = new Track(id, name);
                return track;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.close(results, statement, connection);
        }
    }
	
	public List<Track> findTrackByAlbum(String albumid) {
		ChinookDatabase db = new ChinookDatabase();
        Connection connection = db.connect();
        PreparedStatement statement = null;
        ResultSet results = null;
        ArrayList<Track> list = new ArrayList<>();
       
        System.out.println(albumid);
        
      
        
        try {
            statement = connection.prepareStatement("SELECT *, Genre.Name AS Genrename, Artist.Name AS Artistname FROM Track LEFT JOIN Genre ON Genre.GenreId = Track.GenreId LEFT JOIN Album ON Album.AlbumId = Track.AlbumId LEFT JOIN Artist ON Artist.ArtistId = Album.ArtistId WHERE Track.AlbumId = ?");
            statement.setLong(1, Long.parseLong(albumid));
            results = statement.executeQuery();
            
            
        
            while (results.next()) {
            	long id = results.getLong("TrackId");
				String name = results.getString("Name");
				long mediatypeid = results.getLong("MediatypeId");
				long genreid = results.getLong("GenreId");
				String composer = results.getString("Composer");
				long milliseconds = results.getLong("Milliseconds");
				long bytes = results.getLong("Bytes");
				double unitprice = results.getDouble("Unitprice");
				String genrename = results.getString("Genrename");
				String artistname = results.getString("Artistname");
				
				Track track = new Track(id, name, mediatypeid, genreid, composer, milliseconds, bytes, unitprice, genrename, artistname);
               
                list.add(track);
            } 
           
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.close(results, statement, connection);
        }  return list;
    }

}