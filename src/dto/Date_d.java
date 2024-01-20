package dto;

import java.sql.Time;
import java.util.Date;

public class Date_d {

	private int id_aut_date ;
	private Date id_date;
	private Time  hour_d;
	
	public Date_d(Date id_date, Time hour_d) {
		this.id_date = id_date;
		this.hour_d = hour_d;
	}

	public Date_d(Date id_date) {
		this.id_date = id_date;
	
	}
	

	public Date_d(int id_aut_date, Date id_date, Time hour_d) {
		super();
		this.id_aut_date = id_aut_date;
		this.id_date = id_date;
		this.hour_d = hour_d;
	}

	public int getId_aut_date() {
		return id_aut_date;
	}

	public void setId_aut_date(int id_aut_date) {
		this.id_aut_date = id_aut_date;
	}

	public Date getId_date() {
		return id_date;
	}

	public void setId_date(Date id_date) {
		this.id_date = id_date;
	}

	public Time getHour_d() {
		return hour_d;
	}

	public void setHour_d(Time hour_d) {
		this.hour_d = hour_d;
	}
	
	
	
	
}
