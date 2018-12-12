package recordstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recordstore.dao.ArtistDao;
import recordstore.models.Artist;


@WebServlet("/artistsearch")
public class ArtistSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtistDao artistDao = new ArtistDao();
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String artistname = req.getParameter("artistname");
		
	

		if (true) {
			
			List<Artist> artists = artistDao.searchForArtist(artistname);
			req.setAttribute("artists", artists);
		
		req.getRequestDispatcher("/WEB-INF/views/artist.jsp").include(req, resp);
	}
	
	}
	}


