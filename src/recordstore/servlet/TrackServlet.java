package recordstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import recordstore.database.ChinookDatabase;
import recordstore.models.Album;
import recordstore.models.Artist;
import recordstore.dao.AlbumDao;
import recordstore.dao.ArtistDao;

@WebServlet("/tracks")
public class TrackServlet extends HttpServlet {
    private AlbumDao albumDao = new AlbumDao();
    private ArtistDao artistDao = new ArtistDao();
    

    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String albumid = req.getParameter("id");
    	
    	if (albumid == null || albumid.equals("") ) {
    		PrintWriter writer = resp.getWriter();
            List<Artist> artists = artistDao.getAllArtists();
            req.setAttribute("artists", artists);
          
            	
            	 
                   
            
    	} /* else {
    		PrintWriter out = resp.getWriter();
            long id = Long.parseLong(req.getParameter("id"));

            Artist artist = artistDao.findArtist(id);
            List<Album> albums = albumDao.findAlbumByArtist(artist);
            
            System.out.println(albums);
            

            req.setAttribute("artist", artist);
            req.setAttribute("albums", albums);
    }*/
}
}