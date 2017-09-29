package com.nasa.model;

public class AsteroidInfo {

	  private String name;
	    private String estimatedMaxSize;
	    private String estimatedMinSize;
	    private String distanceToEarth;
	    private Asteroid asteroid;

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEstimatedMaxSize() {
	        return estimatedMaxSize;
	    }

	    public void setEstimatedMaxSize(String estimatedMaxSize) {
	        this.estimatedMaxSize = estimatedMaxSize;
	    }

	    public String getEstimatedMinSize() {
	        return estimatedMinSize;
	    }

	    public void setEstimatedMinSize(String estimatedMinSize) {
	        this.estimatedMinSize = estimatedMinSize;
	    }

	    public String getDistanceToEarth() {
	        return distanceToEarth;
	    }

	    public void setDistanceToEarth(String distanceToEarth) {
	        this.distanceToEarth = distanceToEarth;
	    }

		public Asteroid getAsteroid() {
			return asteroid;
		}

		public void setAsteroid(Asteroid asteroid) {
			this.asteroid = asteroid;
		}

	    
}
