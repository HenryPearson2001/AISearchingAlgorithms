package npuzzle;

import search.TreeSearch;
import search.GraphSearch;
import search.IterativeDeepeningTreeSearch;
import search.DepthFirstFrontier;
import search.BreadthFirstFrontier;
import search.Frontier;
import search.GoalTest;
import search.Node;
import search.NodeFunction;
import search.AStarFunction;
import search.BestFirstFrontier;

public class demos {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of different searches on 8-puzzle");
		System.out.println();

		Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});

		GoalTest goalTest = new TilesGoalTest();

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
		Node solution1 = depthFirstTreeSearch.solve(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSolution(solution1);
		System.out.println("Number of nodes in search: " + depthFirstFrontier.getTotalNodes());
		System.out.println("Max number of nodes in frontier: " + depthFirstFrontier.getMaxStored());
		depthFirstFrontier.resetCounts();
		*/

        /*
		System.out.println("Breadth first tree search:");
		System.out.println();
		Node solution2 = breadthFirstTreeSearch.solve(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSolution(solution2);
		System.out.println("Number of nodes in search: " + breadthFirstFrontier.getTotalNodes());
		System.out.println("Max number of nodes in frontier: " + breadthFirstFrontier.getMaxStored());
		breadthFirstFrontier.resetCounts();
		System.out.println();

		System.out.println("Depth first graph search:");
		System.out.println();
		Node solution3 = depthFirstGraphSearch.solve(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSolution(solution3);
		System.out.println("Number of nodes in search: " + depthFirstFrontier.getTotalNodes());
		System.out.println("Max number of nodes in frontier: " + depthFirstFrontier.getMaxStored());
		depthFirstFrontier.resetCounts();
		System.out.println();

		System.out.println("Breadth first graph search:");
		System.out.println();
		Node solution4 = breadthFirstGraphSearch.solve(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSolution(solution4);
		System.out.println("Number of nodes in search: " + breadthFirstFrontier.getTotalNodes());
		System.out.println("Max number of nodes in frontier: " + breadthFirstFrontier.getMaxStored());
		breadthFirstFrontier.resetCounts();
		System.out.println();

		System.out.println("Iterative deepening tree search:");
		System.out.println();
		Node solution5 = iterativeDeepeningTreeSearch.solve(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSolution(solution5);
		iterativeDeepeningTreeSearch.outputStats();
		iterativeDeepeningTreeSearch.resetCounts();
		System.out.println();
        */

		// tests for lab 2
		NodeFunction heuristicFunction = new MisplacedTilesHeuristicFunction();
		NodeFunction costFunction = new AStarFunction(heuristicFunction);
		Frontier AStarFrontier = new BestFirstFrontier(costFunction);

		TreeSearch AStarTreeSearch = new TreeSearch(AStarFrontier);
		GraphSearch AStarGraphSearch = new GraphSearch(AStarFrontier);


		System.out.println("A* tree search:");
		System.out.println();
		Node solution6 = AStarTreeSearch.solve(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSolution(solution6);
		System.out.println("Number of nodes in search: " + AStarFrontier.getTotalNodes());
		System.out.println("Max number of nodes in frontier: " + AStarFrontier.getMaxStored());
		AStarFrontier.resetCounts();
		System.out.println();


		System.out.println("A* graph search:");
		System.out.println();
		Node solution7 = AStarGraphSearch.solve(initialConfiguration, goalTest);
		new NPuzzlePrinting().printSolution(solution7);
		System.out.println("Number of nodes in search: " + AStarFrontier.getTotalNodes());
		System.out.println("Max number of nodes in frontier: " + AStarFrontier.getMaxStored());
		AStarFrontier.resetCounts();
		System.out.println();

	}
}
