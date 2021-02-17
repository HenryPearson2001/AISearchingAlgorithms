package search;

public interface Frontier {

    // adds a node to the frontier
    public void addNode(Node node);

    // empties the frontier
    public void clearContents();

    // returns whether the frontier is empty
    public boolean isEmpty();

    // returns the node being removed from frontier
    public Node remove();

    // methods for tracking efficiency
    public int getTotalNodes();

    public int getMaxStored();

    public void resetCounts();

}