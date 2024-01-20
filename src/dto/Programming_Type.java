package dto;

public class Programming_Type {
	
	private int id_aut_prog_type ;
	private String prog_type_name ;

	public Programming_Type(int id_aut_prog_type, String prog_type_name) {
		this.id_aut_prog_type = id_aut_prog_type;
		this.prog_type_name = prog_type_name;
	}

	public Programming_Type(String prog_type_name) {
		this.prog_type_name = prog_type_name;
	}

	public int getId_aut_prog_type() {
		return id_aut_prog_type;
	}

	public void setId_aut_prog_type(int id_aut_prog_type) {
		this.id_aut_prog_type = id_aut_prog_type;
	}

	public String getProg_type_name() {
		return prog_type_name;
	}

	public void setProg_type_name(String prog_type_name) {
		this.prog_type_name = prog_type_name;
	}
	
	
	
	

	
	
}
