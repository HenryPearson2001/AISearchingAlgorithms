package search;

public class AStarFunction implements NodeFunction {

    public NodeFunction h;

    // constructor
    public AStarFunction(NodeFunction h) {
        this.h = h;
    }

    public int function(Node node) {
        return (h.function(node) + node.pathCost);
    }

}