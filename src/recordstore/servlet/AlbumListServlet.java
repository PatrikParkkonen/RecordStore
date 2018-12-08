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
import recordstore.dao.AlbumDao;

@WebServlet("/artists")
public class AlbumListServlet extends HttpServlet {
    private AlbumDao albumDao = new AlbumDao();

    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	PrintWriter writer = resp.getWriter();
       
		List<Album> albums = albumDao.getAllAlbums();

        for (Album a : albums) {
        	writer.println(a.getTitle());
        }

       

    }
}