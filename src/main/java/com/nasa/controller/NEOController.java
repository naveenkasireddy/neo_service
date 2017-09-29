package com.nasa.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.nasa.model.Asteroid;
import com.nasa.model.AsteroidInfo;
import com.nasa.model.Data;
import com.nasa.model.Diameter;
import com.nasa.model.EstimatedDiameter;
import com.nasa.model.Model;
import com.nasa.model.ModelObjects;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/asteroids")
public class NEOController {
	
	private static final String URL = "https://api.nasa.gov/neo/rest/v1/feed?api_key=DEMO_KEY"; 
	
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getListOfNearestObjectsToEarth() throws Exception {
		
		 HttpURLConnection conn = null;
		 Model view = null;
         try {
	            URL url = new URL(URL);

	            conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("Accept", "application/json");

	          
	            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {

	                OBJECT_MAPPER.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	                view = OBJECT_MAPPER.readValue(conn.getInputStream(), Model.class);
	            }else {
	                throw new Exception("Problem getting the data");
	            }
	      }catch (Exception e) {
	            throw new Exception("Problem getting the data", e);
	      }
		
	
		return getNearestObjectsToEarth(view) ;
	}
	
	 public String getNearestObjectsToEarth(Model view) throws IOException {

	        HashMap<String, Double> distanceMap = new HashMap<String, Double>();
	        HashMap<String, Diameter> sizeMap =  new HashMap<String, Diameter>();
	        HashMap<String, Asteroid> asteroidMap =  new HashMap<String, Asteroid>();
	        Double pi = 3.14;

	        for(String key : view.getNear_earth_objects().keySet()){

	            for(Asteroid a :view.getNear_earth_objects().get(key)){

	                EstimatedDiameter eD = a.getEstimated_diameter();
	                Double max_diam =  eD.getMeters().getEstimated_diameter_max();
	                Double min_diam =  eD.getMeters().getEstimated_diameter_min();

	                Double max_size = pi*Math.pow((max_diam/2), 2.0);
	                Double min_size = pi*Math.pow((min_diam/2), 2.0);
	                Diameter diameter = new Diameter();
	                diameter.setEstimated_diameter_max(max_size);
	                diameter.setEstimated_diameter_min(min_size);

	                sizeMap.put(a.getName(), diameter);
	                asteroidMap.put(a.getName(), a);
	                for(Data d : a.getClose_approach_data()){
	                        distanceMap.put(a.getName(), Double.parseDouble(d.getMiss_distance().getKilometers()));
	                }
	            }
	        }

	        // Sorting the map Values
	        List<Map.Entry<String, Diameter>> sizeMapList =
	                new LinkedList<Map.Entry<String, Diameter>>(sizeMap.entrySet());

	        Collections.sort(sizeMapList, new Comparator<Map.Entry<String, Diameter>>() {
	            public int compare(Map.Entry<String, Diameter> o1,
	                               Map.Entry<String, Diameter> o2) {
	                return (o1.getValue().getEstimated_diameter_max()).compareTo(o2.getValue().getEstimated_diameter_max());
	            }
	        });

	        Map<String, Diameter> sizeSortedMap = new LinkedHashMap<String, Diameter>();
	        for (Map.Entry<String, Diameter> entry : sizeMapList) {
	            sizeSortedMap.put(entry.getKey(), entry.getValue());
	        }

	        // Sorting the map Values
	        List<Map.Entry<String, Double>> distanceMapList =
	                new LinkedList<Map.Entry<String, Double>>(distanceMap.entrySet());

	        Collections.sort(distanceMapList, new Comparator<Map.Entry<String, Double>>() {
	            public int compare(Map.Entry<String, Double> o1,
	                               Map.Entry<String, Double> o2) {
	                return (o1.getValue()).compareTo(o2.getValue());
	            }
	        });

	        Map<String, Double> distanceSortedMap = new LinkedHashMap<String, Double>();
	        for (Map.Entry<String, Double> entry : distanceMapList) {
	            distanceSortedMap.put(entry.getKey(), entry.getValue());
	        }

	        final Set<Map.Entry<String, Diameter>> sizeMapValues = sizeSortedMap.entrySet();
	        final int maplength = sizeMapValues.size();
	        final Map.Entry<String,Diameter>[] size = new Map.Entry[maplength];
	        sizeMapValues.toArray(size);

	        Asteroid largest = asteroidMap.get(size[maplength-1].getKey());


	        final Set<Map.Entry<String, Double>> distanceMapValues = distanceSortedMap.entrySet();
	        final int length = distanceMapValues.size();
	        final Map.Entry<String,Double>[] dSize = new Map.Entry[length];
	        distanceMapValues.toArray(dSize);

	        Asteroid closest = asteroidMap.get(dSize[0].getKey());

	        ModelObjects modelObjects = new ModelObjects();
	        modelObjects.setTotalNumberOfObjects(asteroidMap.size());
	        AsteroidInfo info = new AsteroidInfo();
	        info.setName(largest.getName());
	        info.setDistanceToEarth(largest.getClose_approach_data().get(0).getMiss_distance().getKilometers());
	        info.setAsteroid(largest);
	        info.setEstimatedMaxSize(size[length - 1].getValue().getEstimated_diameter_max().toString());
	        info.setEstimatedMinSize(size[length - 1].getValue().getEstimated_diameter_min().toString());
	         modelObjects.setLargestSize(info);

	        AsteroidInfo info1 = new AsteroidInfo();
	        info1.setName(closest.getName());
	        info1.setDistanceToEarth(closest.getClose_approach_data().get(0).getMiss_distance().getKilometers());
	        info1.setAsteroid(closest);
	        info1.setEstimatedMaxSize(sizeMap.get(largest.getName()).getEstimated_diameter_max().toString());
	        info1.setEstimatedMinSize(sizeMap.get(largest.getName()).getEstimated_diameter_min().toString());
	        modelObjects.setClosestToEarth(info1);

	        return OBJECT_MAPPER.writeValueAsString(modelObjects);

	    }
	
	
}
