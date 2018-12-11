package recordstore.models;

public class Track {

	private long id;
	private String name;
	private long mediatypeid;
	private long genreid;
	private String composer;
	private long milliseconds;
	private long bytes;
	private double unitprice;

	public Track(long id, String name, long mediatypeid, long genreid, String composer, long milliseconds, long bytes,
			double unitprice) {
		super();
		this.id = id;
		this.name = name;
		this.mediatypeid = mediatypeid;
		this.genreid = genreid;
		this.composer = composer;
		this.milliseconds = milliseconds;
		this.bytes = bytes;
		this.unitprice = unitprice;
	}
	
	

	public Track(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMediatypeid() {
		return mediatypeid;
	}

	public void setMediatypeid(long mediatypeid) {
		this.mediatypeid = mediatypeid;
	}

	public long getGenreid() {
		return genreid;
	}

	public void setGenreid(long genreid) {
		this.genreid = genreid;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public long getMilliseconds() {
		return milliseconds;
	}

	public void setMilliseconds(long milliseconds) {
		this.milliseconds = milliseconds;
	}

	public long getBytes() {
		return bytes;
	}

	public void setBytes(long bytes) {
		this.bytes = bytes;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

}
