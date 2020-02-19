package data;

public abstract class WorkOfArt {

	private String title;
	
	protected WorkOfArt() {
		this(null);
	}

	protected WorkOfArt(String title) {
		super();
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


}
