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

import recordstore.dao.ArtistDao;
import recordstore.database.ChinookDatabase;
import recordstore.models.Artist;

@WebServlet("/tracks")
public class TrackListServlet extends HttpServlet {
    private ArtistDao artistDao = new ArtistDao();

    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	PrintWriter writer = resp.getWriter();
        List<Artist> artists = artistDao.getAllArtists();

        for (Artist a : artists) {
        	writer.println(a.getName());
        }

       

    }
}