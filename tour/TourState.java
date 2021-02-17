package tour;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import search.Action;
import search.State;

public class TourState implements State {
	protected final Set<City> visitedCities;
	protected final City currentCity;
	
	public TourState(City startCity) {
		this.visitedCities = Collections.emptySet();
		this.currentCity = startCity;
	}
	public TourState(Set<City> visitedCities, City currentCity) {
		this.visitedCities = visitedCities;
		this.currentCity = currentCity;
	}
	public Set<Road> getApplicableActions() {
		return currentCity.outgoingRoads;
	}
	public State getActionResult(Action action) {
		Road road = (Road)action;
		Set<City> newVisitedCities = new LinkedHashSet<City>(visitedCities);
		newVisitedCities.add(road.targetCity);
		return new TourState(newVisitedCities, road.targetCity);
	}

	// equal if both made from TourState class
    // and they are both at the same current city and have visited the same cities
	public boolean equals(Object that) {
	    if (this == that) return true;
	    if (that == null || that.getClass() != this.getClass()) return false;
	    TourState tourState = (TourState) that;
	    return (tourState.visitedCities.equals(this.visitedCities) && (tourState.currentCity == this.currentCity));
	}

	// hashCode is the number of the visited cities
	public int hashCode() {
	    return this.visitedCities.size();
	}
}
