package data;

import java.io.Serializable;

import javax.validation.constraints.Min;

import util.fwk.reflect.annotation.Column;
import util.fwk.reflect.annotation.Entity;

@Entity(name = "movies")
public class Movie extends WorkOfArt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6678809181338412709L;

	
	@Min(1850)
	private int annee;

	@Min(0)
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

	@Column
	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}
	@Column
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
