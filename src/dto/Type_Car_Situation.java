package dto;

public class Type_Car_Situation {
	
	private int idtypesitc;
	private String typesitcname;
	
	
	
	public Type_Car_Situation(int idtypesitc, String typesitcname) {
		this.idtypesitc = idtypesitc;
		this.typesitcname = typesitcname;
	}
	
	
	public int getIdtypesitc() {
		return idtypesitc;
	}
	public void setIdtypesitc(int idtypesitc) {
		this.idtypesitc = idtypesitc;
	}
	public String getTypesitcname() {
		return typesitcname;
	}
	public void setTypesitcname(String typesitcname) {
		this.typesitcname = typesitcname;
	}
	

}
