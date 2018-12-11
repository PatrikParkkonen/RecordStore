package recordstore.models;

public class Album {
	
	private long id;
	private String title;
	
	private String albumArtist;
	
	
	public Album(long id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public Album(long id, String title, String albumArtist) {
		this.id = id;
		this.title = title;
		this.setAlbumArtist(albumArtist);
	}
	
	public String getTitle() {
		return title;
	}

	

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAlbumArtist() {
		return albumArtist;
	}

	public void setAlbumArtist(String albumArtist) {
		this.albumArtist = albumArtist;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	

}

