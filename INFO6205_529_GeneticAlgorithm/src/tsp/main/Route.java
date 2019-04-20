/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Qifeng
 */
public class Route {
	private ArrayList<City> route;
	double fittness = 0.0; // each route begins with 0 fitness

	public Route(boolean initalize) {
		if (initalize) {
			route = new ArrayList<>();
			for (int i = 0; i < CityManager.getCityManger().size(); i++) {
				route.add(CityManager.getCityManger().get(i)); // Populate the route City objects
			}
		} else {
			route = new ArrayList<>(CityManager.getCityManger().size());
			for (int i = 0; i < CityManager.getCityManger().size(); i++) {
				route.add(null);
			}
		}
	}
	
	/**
	 * Calculate the entire distance if TS goes to each city and return it which is it's fitness value
	 * @return
	 */
	public double getDistance() {

		double sum = 0.0;

		for (int i = 0; i < route.size(); i++) {
			if (route.get(i) == null)
				break;
			if (i + 1 >= route.size()) { // Check if reached the last element in the array
				break;
			} else { // Elucidian distance between two cities
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
		Collections.shuffle(route);
		this.fittness = getDistance();
	}

	public void sortRoute() {
		Collections.sort(route);
	}

	public int getSize() {
		return route.size();
	}

	// Setters & Getters
	public double getFittness() {
		return fittness;
	}

	public void setFittness() {
		this.fittness = getDistance();
	}

	public ArrayList<City> getRoute() {
		return route;
	}

	public void show() {
		if (route.get(0) == null) {
			System.out.println("No city to show");
			;
		} else {
			System.out.print("{");
			for (City city : route) {
				System.out.print(city.getIndex() + ",");
			}
			System.out.print("}");
			// System.out.println("");
		}
	}
	
}
