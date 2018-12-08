package recordstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import recordstore.models.Album;


class AlbumDaoTest {

	@Test
	public void testAlbumListIsNotEmpty() {
		AlbumDao dao = new AlbumDao();
		List<Album> all = dao.getAllAlbums();
		
		assertEquals(false, all.isEmpty());
	}
	
	
	@Test
	public void testTheNameOfTheFirstAlbum() {
		AlbumDao dao = new AlbumDao();
		List<Album> all = dao.getAllAlbums();
		
		assertEquals("...And Justice For All", all.get(0).getTitle());
	}

}
