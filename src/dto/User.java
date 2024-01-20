package dto;

public class User {
	
	private int id_aut_user;
	private String user_name;
	private String password_user;
	private int id_driver;
	private int id_aut_role;
	
	public User(String user_name, String password_user, int id_driver,
			int id_aut_role) {
		this.user_name = user_name;
		this.password_user = password_user;
		this.id_driver = id_driver;
		this.id_aut_role = id_aut_role;
	}

	public User(int id_aut_user, String user_name, String password_user,
			int id_driver, int id_aut_role) {
		this.id_aut_user = id_aut_user;
		this.user_name = user_name;
		this.password_user = password_user;
		this.id_driver = id_driver;
		this.id_aut_role = id_aut_role;
	}

	public int getId_aut_user() {
		return id_aut_user;
	}

	public void setId_aut_user(int id_aut_user) {
		this.id_aut_user = id_aut_user;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword_user() {
		return password_user;
	}

	public void setPassword_user(String password_user) {
		this.password_user = password_user;
	}

	public int getId_driver() {
		return id_driver;
	}

	public void setId_driver(int id_driver) {
		this.id_driver = id_driver;
	}

	public int getId_aut_role() {
		return id_aut_role;
	}

	public void setId_aut_role(int id_aut_role) {
		this.id_aut_role = id_aut_role;
	}
	
	
	

	
	
}