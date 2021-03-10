package search;

import java.util.PriorityQueue;

public class BestFirstFrontier implements Frontier {

    private PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
    private int totalNodes = 0;
    private int maxStored = 0;
    private NodeFunction costFunction;

    public BestFirstFrontier(NodeFunction costFunction) {
        this.costFunction = costFunction;
    }

    public void addNode(Node node) {
        totalNodes += 1;
        if (frontier.size() > maxStored) {
            maxStored = frontier.size();
        }
        // set the nodes value
        node.value = this.costFunction.function(node);
        this.frontier.add(node);
    }

    public void clearContents() {
        this.frontier.clear();
    }

    public boolean isEmpty() {
        return this.frontier.isEmpty();
    }

    public Node remove() {
        return this.frontier.poll();
    }

    // methods for tracking efficiency
    public int getTotalNodes() {
        return this.totalNodes;
    }

    public int getMaxStored() {
        return this.maxStored;
    }

    public void resetCounts() {
        this.totalNodes = 0;
        this.maxStored = 0;
    }
}