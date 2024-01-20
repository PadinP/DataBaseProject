package dto;

public class Mod_Change {
	
	private String modificationcode;
	private String idchangetype;
	
	public Mod_Change(String modificationcode, String idchangetype) {
		this.modificationcode = modificationcode;
		this.idchangetype = idchangetype;
	}

	public String getModificationcode() {
		return modificationcode;
	}

	public void setModificationcode(String modificationcode) {
		this.modificationcode = modificationcode;
	}

	public String getIdchangetype() {
		return idchangetype;
	}

	public void setIdchangetype(String idchangetype) {
		this.idchangetype = idchangetype;
	}
}
