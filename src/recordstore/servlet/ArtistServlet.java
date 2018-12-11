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

import recordstore.dao.AlbumDao;
import recordstore.dao.ArtistDao;
import recordstore.database.ChinookDatabase;
import recordstore.models.Album;
import recordstore.models.Artist;

@WebServlet("/artist")
public class ArtistServlet extends HttpServlet {

    private ArtistDao artistDao = new ArtistDao();
    private AlbumDao albumDao = new AlbumDao();

    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	if (req.getParameter("id") == null) {
    		return;
    	}
    	
    	PrintWriter out = resp.getWriter();
        long id = Long.parseLong(req.getParameter("id"));

        Artist artist = artistDao.findArtist(id);
        List<Album> albums = albumDao.findAlbumByArtist(artist);
        System.out.println(albums);

        req.setAttribute("artist", artist);
        req.setAttribute("albums", albums);
        
        out.print(albums);
        
        for (Album a : albums) {
        	out.println(a.getTitle());
        }


       // RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/artist.jsp");
       // dispatcher.include(req, resp);
    }
}