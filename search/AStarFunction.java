package search;

class AStarFunction implements NodeFunction {

    public final NodeFunction h;

    // constructor
    public void AStarFunction(NodeFunction h) {
        this.h = h;
    }

    public int function(Node node) {
        return (h(node) + node.pathCost)
    }

}