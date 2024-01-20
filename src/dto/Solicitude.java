package dto;

import java.sql.Time;
import java.util.Date;

public class Solicitude {
	
	private int id_solicitude;
	private Time programming_start_time;
	private String programming_to_be_done;
	private int duration_time;
	private int id_car;
	private int mileage;
	private int id_aut_date;
	private int id_aut_prog_type;
	private int id_group;
	
	public Solicitude(int id_solicitude, Time programming_start_time,
			String programming_to_be_done, int duration_time, int id_car,
			int mileage, int id_aut_date, int id_aut_prog_type, int id_group) {
		this.id_solicitude = id_solicitude;
		this.programming_start_time = programming_start_time;
		this.programming_to_be_done = programming_to_be_done;
		this.duration_time = duration_time;
		this.id_car = id_car;
		this.mileage = mileage;
		this.id_aut_date = id_aut_date;
		this.id_aut_prog_type = id_aut_prog_type;
		this.id_group = id_group;
	}

	public Solicitude(Time programming_start_time,
			String programming_to_be_done, int duration_time, int id_car,
			int mileage, int id_aut_date, int id_aut_prog_type, int id_group) {
		this.programming_start_time = programming_start_time;
		this.programming_to_be_done = programming_to_be_done;
		this.duration_time = duration_time;
		this.id_car = id_car;
		this.mileage = mileage;
		this.id_aut_date = id_aut_date;
		this.id_aut_prog_type = id_aut_prog_type;
		this.id_group = id_group;
	}

	public int getId_solicitude() {
		return id_solicitude;
	}

	public void setId_solicitude(int id_solicitude) {
		this.id_solicitude = id_solicitude;
	}

	public Time getProgramming_start_time() {
		return programming_start_time;
	}

	public void setProgramming_start_time(Time programming_start_time) {
		this.programming_start_time = programming_start_time;
	}

	public String getProgramming_to_be_done() {
		return programming_to_be_done;
	}

	public void setProgramming_to_be_done(String programming_to_be_done) {
		this.programming_to_be_done = programming_to_be_done;
	}

	public int getDuration_time() {
		return duration_time;
	}

	public void setDuration_time(int duration_time) {
		this.duration_time = duration_time;
	}

	public int getId_car() {
		return id_car;
	}

	public void setId_car(int id_car) {
		this.id_car = id_car;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getId_aut_date() {
		return id_aut_date;
	}

	public void setId_aut_date(int id_aut_date) {
		this.id_aut_date = id_aut_date;
	}

	public int getId_aut_prog_type() {
		return id_aut_prog_type;
	}

	public void setId_aut_prog_type(int id_aut_prog_type) {
		this.id_aut_prog_type = id_aut_prog_type;
	}

	public int getId_group() {
		return id_group;
	}

	public void setId_group(int id_group) {
		this.id_group = id_group;
	}
	
	
	
	

	
	
}
