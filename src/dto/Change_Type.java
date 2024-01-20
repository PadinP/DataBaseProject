package dto;

public class Change_Type {
	
	private String idchangetype;
	private String changetypename;
	
	public Change_Type(String idchangetype, String changetypename) {
		this.idchangetype = idchangetype;
		this.changetypename = changetypename;
	}

	public String getIdchangetype() {
		return idchangetype;
	}

	public void setIdchangetype(String idchangetype) {
		this.idchangetype = idchangetype;
	}

	public String getChangetypename() {
		return changetypename;
	}

	public void setChangetypename(String changetypename) {
		this.changetypename = changetypename;
	}
}
