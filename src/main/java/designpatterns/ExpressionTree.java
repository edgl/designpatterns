package designpatterns;

public class ExpressionTree {
	private ComponentNode root;
	
	public ExpressionTree(ComponentNode root) {
		this.root = root;
	}
	
	public void accept(Visitor visitor) {
		root.accept(visitor);
	}

}
