package com.nasa.model;

import java.util.Date;

public class Data {

	private String close_approach_date;
	private Date epoch_date_close_approach;
	private Velocity relative_velocity;
	private Distance miss_distance;
	private String orbiting_body;
	
	public String getClose_approach_date() {
		return close_approach_date;
	}
	public void setClose_approach_date(String close_approach_date) {
		this.close_approach_date = close_approach_date;
	}
	public Date getEpoch_date_close_approach() {
		return epoch_date_close_approach;
	}
	public void setEpoch_date_close_approach(Date epoch_date_close_approach) {
		this.epoch_date_close_approach = epoch_date_close_approach;
	}
	public Velocity getRelative_velocity() {
		return relative_velocity;
	}
	public void setRelative_velocity(Velocity relative_velocity) {
		this.relative_velocity = relative_velocity;
	}
	public Distance getMiss_distance() {
		return miss_distance;
	}
	public void setMiss_distance(Distance miss_distance) {
		this.miss_distance = miss_distance;
	}
	public String getOrbiting_body() {
		return orbiting_body;
	}
	public void setOrbiting_body(String orbiting_body) {
		this.orbiting_body = orbiting_body;
	}
}
