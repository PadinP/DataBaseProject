package dto;

public class Role {
	
	private String idautrole;
	private String roletype;
	
	public Role(String idautrole, String roletype) {
		this.idautrole = idautrole;
		this.roletype = roletype;
	}

	public String getIdautrole() {
		return idautrole;
	}

	public void setIdautrole(String idautrole) {
		this.idautrole = idautrole;
	}

	public String getRoletype() {
		return roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
}
