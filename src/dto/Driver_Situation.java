package dto;

import java.util.Date;

public class Driver_Situation {
	
	private int dscode;
	private Date returndateds;
	private Date currentdateds;
	private int idtypesitd;
	
	public Driver_Situation(int dscode, Date returndateds, Date currentdateds,
			int idtypesitd) {
		this.dscode = dscode;
		this.returndateds = returndateds;
		this.currentdateds = currentdateds;
		this.idtypesitd = idtypesitd;
	}
	
	public Driver_Situation(Date returndateds, Date currentdateds,
			int idtypesitd) {
		super();
		this.returndateds = returndateds;
		this.currentdateds = currentdateds;
		this.idtypesitd = idtypesitd;
	}

	public int getDscode() {
		return dscode;
	}

	public void setDscode(int dscode) {
		this.dscode = dscode;
	}

	public Date getReturndateds() {
		return returndateds;
	}

	public void setReturndateds(Date returndateds) {
		this.returndateds = returndateds;
	}

	public Date getCurrentdateds() {
		return currentdateds;
	}

	public void setCurrentdateds(Date currentdateds) {
		this.currentdateds = currentdateds;
	}

	public int getIdtypesitd() {
		return idtypesitd;
	}

	public void setIdtypesitd(int idtypesitd) {
		this.idtypesitd = idtypesitd;
	}

	
	
}