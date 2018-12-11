package recordstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recordstore.dao.AlbumDao;
import recordstore.dao.ArtistDao;
import recordstore.models.Album;
import recordstore.models.Artist;

@WebServlet("/albums")
public class AlbumServlet extends HttpServlet {

	private ArtistDao artistDao = new ArtistDao();
	private AlbumDao albumDao = new AlbumDao();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String artistid = req.getParameter("artistid");
		List<Album> albums = null;
		String albumartist = "";

		if (artistid == null || artistid.equals("")) {
			PrintWriter writer = resp.getWriter();
			albums = albumDao.getAllAlbums();
			

		}

		else if (!artistid.equals("") || artistid != null) {
			albums = albumDao.findAlbumByArtist(artistid);
			albumartist = albums.get(0).getAlbumArtist();
		}
		System.out.println(albumartist);
		req.setAttribute("albums", albums);
		req.setAttribute("albumartist", albumartist);
		req.getRequestDispatcher("/WEB-INF/views/albums.jsp").include(req, resp);

	}

}
