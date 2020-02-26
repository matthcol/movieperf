package data;

import util.fwk.reflect.annotation.Column;

public abstract class WorkOfArt {

	private String title;
	
	protected WorkOfArt() {
		this(null);
	}

	protected WorkOfArt(String title) {
		super();
		this.title = title;
	}
	
	@Column
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


}
