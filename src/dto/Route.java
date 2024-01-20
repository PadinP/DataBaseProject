package dto;

import java.sql.Time;
import java.util.Date;

public class Route {
	
	private int id_route;
	private double km_available_start;
	private double km_available_end;
	private String pick_up_location;
	private Time end_time;
	private int id_solicitude;
	
	public Route(int id_route, double km_available_start,
			double km_available_end, String pick_up_location, Time end_time,
			int id_solicitude) {
		this.id_route = id_route;
		this.km_available_start = km_available_start;
		this.km_available_end = km_available_end;
		this.pick_up_location = pick_up_location;
		this.end_time = end_time;
		this.id_solicitude = id_solicitude;
	}

	public Route(double km_available_start, double km_available_end,
			String pick_up_location, Time end_time, int id_solicitude) {
		this.km_available_start = km_available_start;
		this.km_available_end = km_available_end;
		this.pick_up_location = pick_up_location;
		this.end_time = end_time;
		this.id_solicitude = id_solicitude;
	}

	
	public int getId_route() {
		return id_route;
	}

	public void setId_route(int id_route) {
		this.id_route = id_route;
	}

	public double getKm_available_start() {
		return km_available_start;
	}

	public void setKm_available_start(double km_available_start) {
		this.km_available_start = km_available_start;
	}

	public double getKm_available_end() {
		return km_available_end;
	}

	public void setKm_available_end(double km_available_end) {
		this.km_available_end = km_available_end;
	}

	public String getPick_up_location() {
		return pick_up_location;
	}

	public void setPick_up_location(String pick_up_location) {
		this.pick_up_location = pick_up_location;
	}

	public Time getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
	}

	public int getId_solicitude() {
		return id_solicitude;
	}

	public void setId_solicitude(int id_solicitude) {
		this.id_solicitude = id_solicitude;
	}
	
	
	
	
	
}
