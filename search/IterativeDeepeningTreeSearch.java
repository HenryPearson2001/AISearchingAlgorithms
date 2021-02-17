package search;

public class IterativeDeepeningTreeSearch implements Search {

    private Frontier frontier = new DepthFirstFrontier();

    public Node solve(State initialConfiguration, GoalTest goalTest) {
        int count = 1;
        Node result = null;
        while (result == null) {
            result = depthLimitedSearch(new Node(null, null, initialConfiguration, 0), goalTest, count);
            count = count + 1;
        }
        return result;
    }

    private Node depthLimitedSearch(Node root, GoalTest goalTest, int maxDepth) {
        frontier.addNode(root);
        while (!frontier.isEmpty()) {
            Node nextNode = frontier.remove();
            int depth = nextNode.depth;
            if (goalTest.isGoal(nextNode.state)) {
                frontier.clearContents();
                return nextNode;
            }
            else if (depth < maxDepth) {
                for (Action action : nextNode.state.getApplicableActions()) {
					State newState = nextNode.state.getActionResult(action);
					frontier.addNode(new Node(nextNode, action, newState, depth + 1));
				}
            }
        }
        return null;
    }

    public void outputStats() {
        System.out.println("Number of nodes in search: " + frontier.getTotalNodes());
		System.out.println("Max number of nodes in frontier: " + frontier.getMaxStored());
    }

    public void resetCounts() {
        this.frontier.resetCounts();
    }
}