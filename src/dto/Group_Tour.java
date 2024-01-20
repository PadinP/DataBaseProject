package dto;

public class Group_Tour {
	
	private int id_group;
	private int group_code;
	private String group_country;
	private int number_of_tourists;
	
	public Group_Tour(int id_group, int group_code, String group_country,
			int number_of_tourists) {
		this.id_group = id_group;
		this.group_code = group_code;
		this.group_country = group_country;
		this.number_of_tourists = number_of_tourists;
	}

	public Group_Tour(int group_code, String group_country,
			int number_of_tourists) {
		super();
		this.group_code = group_code;
		this.group_country = group_country;
		this.number_of_tourists = number_of_tourists;
	}

	public int getId_group() {
		return id_group;
	}

	public void setId_group(int id_group) {
		this.id_group = id_group;
	}

	public int getGroup_code() {
		return group_code;
	}

	public void setGroup_code(int group_code) {
		this.group_code = group_code;
	}

	public String getGroup_country() {
		return group_country;
	}

	public void setGroup_country(String group_country) {
		this.group_country = group_country;
	}

	public int getNumber_of_tourists() {
		return number_of_tourists;
	}

	public void setNumber_of_tourists(int number_of_tourists) {
		this.number_of_tourists = number_of_tourists;
	}
	
	

	
	
}
