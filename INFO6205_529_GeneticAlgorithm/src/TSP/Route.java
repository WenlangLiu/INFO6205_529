/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Wenlang
 */
public class Route {
	private ArrayList<City> route;
	double fittness = 0.0; // each route begins with 0 fitness
	
	
	public Route(boolean initalize) { // Route pre filled with cities?
		if (initalize) {
			route = new ArrayList<>();
			for (int i = 0; i < CityManager.getCityManger().size(); i++) {
				route.add(CityManager.getCityManger().get(i)); // Populate the route City objects
			}
		} else {
			route = new ArrayList<>();
			for (int i = 0; i < CityManager.getCityManger().size(); i++) {
				route.add(null);
			}
		}
	}

	public double getDistance() {
		
		
		double sum = 0.0;
		
		for (int i = 0; i < route.size(); i++) {
			if (route.get(i) == null)
				break;
			if (i + 1 >= route.size()) { // Check if reached the last element in the array
				break;
			} else if(route.get(i)!=null&&route.get(i+1)!=null){ // Elucidian distance between two cities
				int x1 = route.get(i).getX();
				int x2 = route.get(i + 1).getX();
				int y1 = route.get(i).getY();
				int y2 = route.get(i + 1).getY();

				sum = sum + Math.sqrt(((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
			}
		}
		return sum;
	}

	public void generateIndividualRoute() {
		// Assuming route is filled with cities -> simple shuffle to create an
		// individual
		Collections.shuffle(route);
		this.fittness = getDistance(); // inverse could work
	}

	
	
	public void setRoute(ArrayList<City> route) {
		this.route = route;
	}

	public void sortRoute() {
		Collections.sort(route); // Hope it works ... used Comparable
	}

	public int getSize() {
		return route.size();
	}

	// Setters & Getters
	public double getFittness() {
		return getDistance();
	}

	public void setFittness(double fittness) {
		this.fittness = fittness;
	}

	public ArrayList<City> getRoute() {
		return route;
	}

	public void show() {
		if (route.get(0) == null) {
			System.out.println("No city to show");;
		} else {
			System.out.print("{");
			for (City city : route) {
				if(city==null) continue;
				System.out.print(city.getIndex() + ",");
			}
			System.out.print("}");
			System.out.println("");

		}
	}

}
