package data;

import java.io.Serializable;

public class Movie extends WorkOfArt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6678809181338412709L;

	private int annee;
	private int duration;
	
	public Movie() {
		
	}

	public Movie(String title, int annee, int duration) {
		super(title);
		this.annee = annee;
		this.duration = duration;
	}

	public Movie(String title, int annee) {
		this(title,annee,0);
	}


	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(getTitle());
		sb.append(" (")
		.append(annee);
		
		if (duration > 0)
			sb.append(", ")
			.append(+duration)
			.append("mn");			
		return sb.append(")").toString();
	}

}
