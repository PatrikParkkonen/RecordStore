package recordstore.models;

public class Track {

	private long id;
	private String name;
	private long mediatypeid;
	private long genreid;
	private String composer;
	private int milliseconds;
	private int bytes;
	private int unitprice;

	public Track(long id, String name, long mediatypeid, long genreid, String composer, int milliseconds, int bytes,
			int unitprice) {
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

	public int getMilliseconds() {
		return milliseconds;
	}

	public void setMilliseconds(int milliseconds) {
		this.milliseconds = milliseconds;
	}

	public int getBytes() {
		return bytes;
	}

	public void setBytes(int bytes) {
		this.bytes = bytes;
	}

	public int getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}

}
