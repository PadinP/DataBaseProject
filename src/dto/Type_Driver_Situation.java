package dto;

public class Type_Driver_Situation {
	
	private int idtypesitd;
	private String typesitdname;
	
	public Type_Driver_Situation(int idtypesitd, String typesitdname) {
		super();
		this.idtypesitd = idtypesitd;
		this.typesitdname = typesitdname;
	}

	public Type_Driver_Situation(String typesitdname) {
		super();
		this.typesitdname = typesitdname;
	}

	public int getIdtypesitd() {
		return idtypesitd;
	}

	public void setIdtypesitd(int idtypesitd) {
		this.idtypesitd = idtypesitd;
	}

	public String getTypesitdname() {
		return typesitdname;
	}

	public void setTypesitdname(String typesitdname) {
		this.typesitdname = typesitdname;
	}

	
	
}