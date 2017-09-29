package com.nasa.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Model {
	
	private LinkedHashMap<String, String> links;
	
	private Integer element_count;
	
	public LinkedHashMap<String, String> getLinks() {
		return links;
	}

	public void setLinks(LinkedHashMap<String, String> links) {
		this.links = links;
	}

	public Integer getElement_count() {
		return element_count;
	}

	public void setElement_count(Integer element_count) {
		this.element_count = element_count;
	}

	public HashMap<String, ArrayList<Asteroid>> getNear_earth_objects() {
		return near_earth_objects;
	}

	public void setNear_earth_objects(HashMap<String, ArrayList<Asteroid>> near_earth_objects) {
		this.near_earth_objects = near_earth_objects;
	}

	private HashMap<String, ArrayList<Asteroid>> near_earth_objects;
	
}
