package designpatterns;

/**
 * @class CompositeBinaryNode
 * @brief Defines a left and right node (via inheritance).  It plays
 *        the role of a "Composite" in the Composite pattern.
 *
 */
public class CompositeBinaryNode extends CompositeUnaryNode {

	/** Reference to the left child */
	private ComponentNode left;
	
	public CompositeBinaryNode(ComponentNode right, ComponentNode left) {
		super(right);
		this.left = left;
	}
	
	public ComponentNode left() {
		return this.left;
	}

	
}
