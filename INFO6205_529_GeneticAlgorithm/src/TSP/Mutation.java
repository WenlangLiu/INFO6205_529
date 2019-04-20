package TSP;

import java.util.Collections;
import java.util.Random;

public class Mutation {
	public void mutate(double precentage, double mut,Route route,Route child) {
		Random r = new Random();
		if(precentage>=mut) {
			int start = r.nextInt(route.getSize());
			int end = r.nextInt(route.getSize());
			Collections.swap(child.getRoute(), start, end);
		}
	}
}
