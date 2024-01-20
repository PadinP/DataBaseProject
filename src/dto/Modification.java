package dto;

import java.util.Date;

public class Modification {
	
	private String modificationcode;
	private Date modificationdate;
	private String solicitudecode;
	
	public Modification(String modificationcode, Date modificationdate,
			String solicitudecode) {
		this.modificationcode = modificationcode;
		this.modificationdate = modificationdate;
		this.solicitudecode = solicitudecode;
	}

	public String getModificationcode() {
		return modificationcode;
	}

	public void setModificationcode(String modificationcode) {
		this.modificationcode = modificationcode;
	}

	public Date getModificationdate() {
		return modificationdate;
	}

	public void setModificationdate(Date modificationdate) {
		this.modificationdate = modificationdate;
	}

	public String getSolicitudecode() {
		return solicitudecode;
	}

	public void setSolicitudecode(String solicitudecode) {
		this.solicitudecode = solicitudecode;
	}
}
