package search;

import java.util.Stack;

public class DepthFirstFrontier implements Frontier {

    private Stack<Node> frontier = new Stack<Node>();

    private int totalNodes = 0;
    private int maxStored = 0;

    public void addNode(Node node) {
        totalNodes += 1;
        if (frontier.size() > maxStored) {
            maxStored = frontier.size();
        }
        this.frontier.push(node);
    }

    public void clearContents() {
        this.frontier.clear();
    }

    public boolean isEmpty() {
        return this.frontier.isEmpty();
    }

    public Node remove() {
        return this.frontier.pop();
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