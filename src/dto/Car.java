package dto;

public class Car {
	
	private int idCar;
	private String carnumber;
	private String carbrand;
	private int numberofseats;
	private int cscode;
	
	
	public Car(int idCar, String carnumber, String carbrand, int numberofseats,
			int cscode) {
		this.idCar = idCar;
		this.carnumber = carnumber;
		this.carbrand = carbrand;
		this.numberofseats = numberofseats;
		this.cscode = cscode;
	}

	public Car(String carnumber, String carbrand, int numberofseats, int cscode) {
		this.carnumber = carnumber;
		this.carbrand = carbrand;
		this.numberofseats = numberofseats;
		this.cscode = cscode;
	}
	
	

	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getCarbrand() {
		return carbrand;
	}

	public void setCarbrand(String carbrand) {
		this.carbrand = carbrand;
	}

	public int getNumberofseats() {
		return numberofseats;
	}

	public void setNumberofseats(int numberofseats) {
		this.numberofseats = numberofseats;
	}

	public int getCscode() {
		return cscode;
	}

	public void setCscode(int cscode) {
		this.cscode = cscode;
	}
	
	
	
	
	
	
	
}