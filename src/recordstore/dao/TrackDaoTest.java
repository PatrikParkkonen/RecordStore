package recordstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import recordstore.models.Track;

class TrackDaoTest {

	@Test
	public void testTrackListIsNotEmpty() {
		TrackDao dao = new TrackDao();
		List<Track> all = dao.getAllTracks();
		
		assertEquals(false, all.isEmpty());
	}
	
	
	@Test
	public void testTheNameOfTheFirstTrack() {
		TrackDao dao = new TrackDao();
		List<Track> all = dao.getAllTracks();
		
		assertEquals("\"40\"", all.get(0).getName());
	}

}