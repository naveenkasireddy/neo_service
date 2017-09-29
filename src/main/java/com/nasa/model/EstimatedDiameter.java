package com.nasa.model;

public class EstimatedDiameter {

	private Diameter kilometers;
	private Diameter meters;
	private Diameter miles;

	public Diameter getKilometers() {
		return kilometers;
	}
	public void setKilometers(Diameter kilometers) {
		this.kilometers = kilometers;
	}
	public Diameter getMeters() {
		return meters;
	}
	public void setMeters(Diameter meters) {
		this.meters = meters;
	}
	public Diameter getMiles() {
		return miles;
	}
	public void setMiles(Diameter miles) {
		this.miles = miles;
	}
	public Diameter getFeet() {
		return feet;
	}
	public void setFeet(Diameter feet) {
		this.feet = feet;
	}
	private Diameter feet;
	
}
