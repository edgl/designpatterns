package designpatterns;

public abstract class ComponentNode {

	private ComponentNode left;
	private ComponentNode right;

	public int item() {
		throw new UnsupportedOperationException();
	}
	
	public ComponentNode right() {
		return right;
	}
	
	public ComponentNode left() {
		return left;
	}
	
	/**
	 * Accept a visitor to perform some action on the node's
	 * item completely arbitrary visitor template (throws an 
	 * exception if called directly).
	 */
	void accept(Visitor visitor) {
		throw new UnsupportedOperationException("ComponentNode::accpet() called improperly");
	}
}
