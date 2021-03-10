package search;

public class TreeSearch implements Search {

    private Frontier frontier;

    public TreeSearch(Frontier frontier) {
        this.frontier = frontier;
    }

    public Node solve(State initialConfiguration, GoalTest goalTest) {
        this.frontier.addNode(new Node(null, null, initialConfiguration, 0, 0));
        while (!this.frontier.isEmpty()) {
            Node nextNode = frontier.remove();
            if (goalTest.isGoal(nextNode.state)) {
                this.frontier.clearContents();
                return nextNode;
            }
            else {
                for (Action action : nextNode.state.getApplicableActions()) {
					State newState = nextNode.state.getActionResult(action);
					this.frontier.addNode(new Node(nextNode, action, newState, nextNode.depth + 1, nextNode.pathCost + action.cost()));
				}
            }
        }
        return null;
    }
}