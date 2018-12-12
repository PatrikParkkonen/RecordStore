package recordstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recordstore.dao.AlbumDao;
import recordstore.models.Album;

@WebServlet("/albums")
public class AlbumServlet extends HttpServlet {

	
	private AlbumDao albumDao = new AlbumDao();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String artistid = req.getParameter("artistid");
		List<Album> albums = null;
		String albumartist = "";
		
	

		if (artistid == null || artistid.equals("")) {
			
			albums = albumDao.getAllAlbums();
			

		}

		else if (!artistid.equals("") || artistid != null) {
			albums = albumDao.findAlbumByArtist(artistid);
			
			
			if (!albums.isEmpty()) {
				albumartist = albums.get(0).getAlbumArtist();
				req.setAttribute("albums", albums);
			} 
		}
	
		
		req.setAttribute("albumartist", albumartist);
		req.getRequestDispatcher("/WEB-INF/views/albums.jsp").include(req, resp);

	}

}
