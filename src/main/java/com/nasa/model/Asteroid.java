package com.nasa.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Asteroid {

	public HashMap<String, String> getLinks() {
		return links;
	}
	public void setLinks(HashMap<String, String> links) {
		this.links = links;
	}
	public String getNeo_reference_id() {
		return neo_reference_id;
	}
	public void setNeo_reference_id(String neo_reference_id) {
		this.neo_reference_id = neo_reference_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNasa_jpl_url() {
		return nasa_jpl_url;
	}
	public void setNasa_jpl_url(String nasa_jpl_url) {
		this.nasa_jpl_url = nasa_jpl_url;
	}
	public Double getAbsolute_magnitude_h() {
		return absolute_magnitude_h;
	}
	public void setAbsolute_magnitude_h(Double absolute_magnitude_h) {
		this.absolute_magnitude_h = absolute_magnitude_h;
	}
	public EstimatedDiameter getEstimated_diameter() {
		return estimated_diameter;
	}
	public void setEstimated_diameter(EstimatedDiameter estimated_diameter) {
		this.estimated_diameter = estimated_diameter;
	}
	public boolean isIs_potentially_hazardous_asteroid() {
		return is_potentially_hazardous_asteroid;
	}
	public void setIs_potentially_hazardous_asteroid(boolean is_potentially_hazardous_asteroid) {
		this.is_potentially_hazardous_asteroid = is_potentially_hazardous_asteroid;
	}
	public ArrayList<Data> getClose_approach_data() {
		return close_approach_data;
	}
	public void setClose_approach_data(ArrayList<Data> close_approach_data) {
		this.close_approach_data = close_approach_data;
	}
	private HashMap<String, String> links;
	private String neo_reference_id;
	private String name;
	private String nasa_jpl_url;
	private Double absolute_magnitude_h;
	private EstimatedDiameter estimated_diameter;
	private boolean is_potentially_hazardous_asteroid;
	private ArrayList<Data> close_approach_data;
}
