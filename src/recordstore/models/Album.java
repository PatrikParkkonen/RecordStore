package recordstore.models;

public class Album {
	
	private long id;
	private String title;
	
	public Album(long id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	

	public void setTitle(String title) {
		this.title = title;
	}
	

}

