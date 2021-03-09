package search;

public class Node {
	public final Node parent;
	public final Action action;
	public final State state;
	public final int depth;
	public final int value;
	
	public Node(Node parent, Action action, State state, int depth) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		this.depth = depth;
		this.value = 0;
	}
}
