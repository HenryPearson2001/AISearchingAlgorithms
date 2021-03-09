package npuzzle;

import search.NodeFunction;
import search.State;

class MisplacedTilesHeuristicFunction implements NodeFunction {

    public int function(Node node) {
        State state = node.state;
        int count = 0;
        for (int i = 1; i <= 8; i ++) {
            if state.getTile((i-1)/3, (i-1)%3) != i {
                count += 1
            }
        }
        return connt
    }
}