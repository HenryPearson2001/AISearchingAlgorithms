package tour;

import search.TreeSearch;
import search.GraphSearch;
import search.IterativeDeepeningTreeSearch;
import search.DepthFirstFrontier;
import search.BreadthFirstFrontier;
import search.Frontier;
import search.GoalTest;
import search.Node;

public class demos {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of breadth-first tree search on Romania tour");
		System.out.println();

		Cities romania = SetUpRomania.getRomaniaMapSmall();
		City startCity = romania.getState("Bucharest");

		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);

		// different frontier objects
		Frontier breadthFirstFrontier = new BreadthFirstFrontier();
		Frontier depthFirstFrontier = new DepthFirstFrontier();

		// depth first tree search
		TreeSearch depthFirstTreeSearch = new TreeSearch(depthFirstFrontier);
		// breadth first tree search
		TreeSearch breadthFirstTreeSearch = new TreeSearch(breadthFirstFrontier);
		// depth first graph search
		GraphSearch depthFirstGraphSearch = new GraphSearch(depthFirstFrontier);
		// breadth first graph search
		GraphSearch breadthFirstGraphSearch = new GraphSearch(breadthFirstFrontier);
		// iterative deepening search
		IterativeDeepeningTreeSearch iterativeDeepeningTreeSearch = new IterativeDeepeningTreeSearch();

        /*
		// solve and output results
		System.out.println("Depth first tree search:");
		System.out.println();
		Node solution1 = depthFirstTreeSearch.solve(new TourState(startCity), goalTest);
		new TourPrinting().printSolution(solution1);
		System.out.println("Number of nodes in search: " + depthFirstFrontier.getTotalNodes());
		System.out.println("Max number of nodes in frontier: " + depthFirstFrontier.getMaxStored());
		depthFirstFrontier.resetCounts();
		*/

		System.out.println("Breadth first tree search:");
		System.out.println();
		Node solution2 = breadthFirstTreeSearch.solve(new TourState(startCity), goalTest);
		new TourPrinting().printSolution(solution2);
		System.out.println("Number of nodes in search: " + breadthFirstFrontier.getTotalNodes());
		System.out.println("Max number of nodes in frontier: " + breadthFirstFrontier.getMaxStored());
		breadthFirstFrontier.resetCounts();
		System.out.println();

		System.out.println("Depth first graph search:");
		System.out.println();
		Node solution3 = depthFirstGraphSearch.solve(new TourState(startCity), goalTest);
		new TourPrinting().printSolution(solution3);
		System.out.println("Number of nodes in search: " + depthFirstFrontier.getTotalNodes());
		System.out.println("Max number of nodes in frontier: " + depthFirstFrontier.getMaxStored());
		depthFirstFrontier.resetCounts();
		System.out.println();

		System.out.println("Breadth first graph search:");
		System.out.println();
		Node solution4 = breadthFirstGraphSearch.solve(new TourState(startCity), goalTest);
		new TourPrinting().printSolution(solution4);
		System.out.println("Number of nodes in search: " + breadthFirstFrontier.getTotalNodes());
		System.out.println("Max number of nodes in frontier: " + breadthFirstFrontier.getMaxStored());
		breadthFirstFrontier.resetCounts();
		System.out.println();

		System.out.println("Iterative deepening tree search:");
		System.out.println();
		Node solution5 = iterativeDeepeningTreeSearch.solve(new TourState(startCity), goalTest);
		new TourPrinting().printSolution(solution5);
		iterativeDeepeningTreeSearch.outputStats();
		iterativeDeepeningTreeSearch.resetCounts();
		System.out.println();
	}
}