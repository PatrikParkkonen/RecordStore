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
import recordstore.models.Track;
import recordstore.dao.AlbumDao;
import recordstore.dao.ArtistDao;
import recordstore.dao.TrackDao;

@WebServlet("/tracks")
public class TrackServlet extends HttpServlet {

	private ArtistDao artistDao = new ArtistDao();
	private AlbumDao albumDao = new AlbumDao();
	private TrackDao trackDao = new TrackDao();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String albumid = req.getParameter("albumid");
		List<Track> tracks = null;
		String genrename = "";

		if (albumid == null || albumid.equals("")) {
			PrintWriter writer = resp.getWriter();
			tracks = trackDao.getAllTracks();
			

		}

		else if (!albumid.equals("") || albumid != null) {
			tracks = trackDao.findTrackByAlbum(albumid);
			genrename = tracks.get(0).getGenreName();
		}
		// System.out.println(albumartist);
		req.setAttribute("tracks", tracks);
		req.setAttribute("Genre.Name", genrename);
		req.getRequestDispatcher("/WEB-INF/views/tracks.jsp").include(req, resp);

	}

}