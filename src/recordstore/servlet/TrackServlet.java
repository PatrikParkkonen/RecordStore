package recordstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recordstore.dao.TrackDao;
import recordstore.models.Track;

@WebServlet("/tracks")
public class TrackServlet extends HttpServlet {


	private TrackDao trackDao = new TrackDao();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String albumid = req.getParameter("albumid");
		List<Track> tracks = null;
		String genrename = "";
		String artistname = "";

		if (albumid == null || albumid.equals("")) {
			
			tracks = trackDao.getAllTracks();
			

		}

		else if (!albumid.equals("") || albumid != null) {
			tracks = trackDao.findTrackByAlbum(albumid);
			genrename = tracks.get(0).getGenreName();
		}
	
		req.setAttribute("artistname", artistname);
		req.setAttribute("tracks", tracks);
		req.setAttribute("Genre.Name", genrename);
		req.getRequestDispatcher("/WEB-INF/views/tracks.jsp").include(req, resp);

	}

}