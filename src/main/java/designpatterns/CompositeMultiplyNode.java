package designpatterns;

/**
 * @brief A node containing left and right children.  The meaning of
 *        this node is left * right.  It plays the role of a 
 *        "Composite" in the Composite pattern.
 *
 */
public class CompositeMultiplyNode extends CompositeBinaryNode {

	public CompositeMultiplyNode(ComponentNode right, ComponentNode left) {
		super(right, left);
	}

	/** Return the printable character stored in the node. */
	public int item() {
		return '*';
	}
	
	/**
	 * Define the @a accept() operation used for the Vistor pattern
	 * to accept the @a visitor
	 */
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
