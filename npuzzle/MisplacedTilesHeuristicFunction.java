package npuzzle;

import search.NodeFunction;
import search.State;
import search.Node;

public class MisplacedTilesHeuristicFunction implements NodeFunction {

    public int function(Node node) {
        Tiles state = (Tiles)node.state;
        int count = 0;
        for (int i = 1; i <= 8; i ++) {
            if (state.getTile((i-1)/3, (i-1)%3) != i) {
                count += 1;
            }
        }
        return count;
    }
}