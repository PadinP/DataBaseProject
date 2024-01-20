package dto;

import java.util.Date;

public class Car_Situation {
	
	private int cscode;
	private Date returndatecs;
	private Date currentdatecs;
	private int idtypesitc;
	
	public Car_Situation(int cscode, Date returndatecs, Date currentdatecs,
			int idtypesitc){
		this.cscode = cscode;
		this.returndatecs = returndatecs;
		this.currentdatecs = currentdatecs;
		this.idtypesitc = idtypesitc;
	}


	public Car_Situation(Date returndatecs, Date currentdatecs, int idtypesitc) {
		this.returndatecs = returndatecs;
		this.currentdatecs = currentdatecs;
		this.idtypesitc = idtypesitc;
	}






	public int getCscode() {
		return cscode;
	}

	public void setCscode(int cscode) {
		this.cscode = cscode;
	}

	public Date getReturndatecs() {
		return returndatecs;
	}

	public void setReturndatecs(Date returndatecs) {
		this.returndatecs = returndatecs;
	}

	public Date getCurrentdatecs() {
		return currentdatecs;
	}

	public void setCurrentdatecs(Date currentdatecs) {
		this.currentdatecs = currentdatecs;
	}

	public int getIdtypesitc() {
		return idtypesitc;
	}

	public void setIdtypesitc(int idtypesitc) {
		this.idtypesitc = idtypesitc;
	}
}
