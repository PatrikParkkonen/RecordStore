package recordstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import recordstore.models.Artist;

class ArtistDaoTest {

	@Test
	public void testArtistListIsNotEmpty() {
		ArtistDao dao = new ArtistDao();
		List<Artist> all = dao.getAllArtists();
		
		assertEquals(false, all.isEmpty());
	}
	
	
	@Test
	public void testTheNameOfTheFirstArtist() {
		ArtistDao dao = new ArtistDao();
		List<Artist> all = dao.getAllArtists();
		
		assertEquals("A Cor Do Som", all.get(0).getName());
	}

}
