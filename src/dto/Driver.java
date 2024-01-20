package dto;

public class Driver {
	
	private int idDriver;
    private String dni;
	private String drivername;
	private String homeaddress;
	private String category;
	private boolean iscopilot;
	private int dscode;
	private int carnumber;
	
	
	
	public Driver(String dni, String drivername, String homeaddress,
			String category, boolean iscopilot, int dscode) {
		super();
		this.dni = dni;
		this.drivername = drivername;
		this.homeaddress = homeaddress;
		this.category = category;
		this.iscopilot = iscopilot;
		this.dscode = dscode;
	}

	public Driver(int idDriver, String dni, String drivername,
			String homeaddress, String category, boolean iscopilot, int dscode,
			int carnumber) {
		this.idDriver = idDriver;
		this.dni = dni;
		this.drivername = drivername;
		this.homeaddress = homeaddress;
		this.category = category;
		this.iscopilot = iscopilot;
		this.dscode = dscode;
		this.carnumber = carnumber;
	}

	public Driver(String dni, String drivername, String homeaddress,
			String category, boolean iscopilot, int dscode, int carnumber) {
		this.dni = dni;
		this.drivername = drivername;
		this.homeaddress = homeaddress;
		this.category = category;
		this.iscopilot = iscopilot;
		this.dscode = dscode;
		this.carnumber = carnumber;
	}

	public int getIdDriver() {
		return idDriver;
	}

	public void setIdDriver(int idDriver) {
		this.idDriver = idDriver;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public String getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isIscopilot() {
		return iscopilot;
	}

	public void setIscopilot(boolean iscopilot) {
		this.iscopilot = iscopilot;
	}

	public int getDscode() {
		return dscode;
	}

	public void setDscode(int dscode) {
		this.dscode = dscode;
	}

	public int getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(int carnumber) {
		this.carnumber = carnumber;
	}

	
	
	
	
}