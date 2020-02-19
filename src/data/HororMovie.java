package data;

public class HororMovie extends Movie {
	
	private double hororPower;
	public HororMovie() {
		// TODO Auto-generated constructor stub
	}
	
	public HororMovie(String title, int annee, double hororPower) {
		super(title, annee);
		this.hororPower = hororPower;
	}
	public HororMovie(String title, int annee, int duration, double hororPower) {
		super(title, annee, duration);
		this.hororPower = hororPower;
	}

	public double getHororPower() {
		return hororPower;
	}

	public void setHororPower(double hororPower) {
		this.hororPower = hororPower;
	}

	
}
