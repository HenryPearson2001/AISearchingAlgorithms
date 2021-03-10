package tour;

import search.NodeFunction;
import search.State;
import search.Node;

public class RomaniaHeuristicFunction implements NodeFunction {

    private final Cities cities;
    private final City goalCity;

    public RomaniaHeuristicFunction(Cities cities, City goalCity) {
        this.cities = cities
        this.goalCity = goalCity
    }

    public int function(Node node) {
        TourState state = (TourState)node.state;
        Cities visited = state.visitedCities;
        int max = -1
        City maxCity = null
        for (City city : this.cities.getAllCities()) {
            if !visited.contains(city) {
                int current = state.city.getShortestDistanceTo(city);
                if current > max {
                    max = current;
                    maxCity = state.city;
                }
            }
        }
        if maxCity != null {
            int distance = max + maxCity.getShortestDistanceTo(this.goalCity);
            return distance;
        }
        else {
            return state.city.getShortestDistanceTo(this.goalCity);
        }
    }
}