package search;

import java.util.LinkedList;

public class GraphSearch implements Search {

    private Frontier frontier;

    private LinkedList<State> visited = new LinkedList<State>();

    public GraphSearch(Frontier frontier) {
        this.frontier = frontier;
    }

    public Node solve(State initialConfiguration, GoalTest goalTest) {
        this.frontier.addNode(new Node(null, null, initialConfiguration, 0, 0));
        this.visited.add(initialConfiguration);
        while (!this.frontier.isEmpty()) {
            Node nextNode = this.frontier.remove();
            if (goalTest.isGoal(nextNode.state)) {
                this.frontier.clearContents();
                return nextNode;
            }
            else {
                for (Action action : nextNode.state.getApplicableActions()) {
					State newState = nextNode.state.getActionResult(action);
					if (!this.visited.contains(newState)) {
					    this.visited.add(newState);
					    this.frontier.addNode(new Node(nextNode, action, newState, 0, nextNode.pathCost + action.cost()));
					}
				}
            }
        }
        return null;
    }
}