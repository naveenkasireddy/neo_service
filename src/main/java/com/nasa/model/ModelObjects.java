package com.nasa.model;

public class ModelObjects {

	 private Integer totalNumberOfObjects;
	    private AsteroidInfo largestSize;
	    private AsteroidInfo closestToEarth;

	    public Integer getTotalNumberOfObjects() {
	        return totalNumberOfObjects;
	    }

	    public void setTotalNumberOfObjects(Integer totalNumberOfObjects) {
	        this.totalNumberOfObjects = totalNumberOfObjects;
	    }

	    public AsteroidInfo getLargestSize() {
	        return largestSize;
	    }

	    public void setLargestSize(AsteroidInfo largestSize) {
	        this.largestSize = largestSize;
	    }

	    public AsteroidInfo getClosestToEarth() {
	        return closestToEarth;
	    }

	    public void setClosestToEarth(AsteroidInfo closestToEarth) {
	        this.closestToEarth = closestToEarth;
	    }
	}
