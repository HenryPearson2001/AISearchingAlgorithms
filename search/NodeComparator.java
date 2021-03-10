package search;

import java.util.Comparator;
// implements a comparator for Nodes for priority queue
class NodeComparator implements Comparator<Node> {

    public int compare(Node n1, Node n2) {
        return n1.value > n2.value ? 1: -1;
    }

}