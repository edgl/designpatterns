package designpatterns;

public class SynchronizedExpressionTree extends ExpressionTree {

	public SynchronizedExpressionTree(ComponentNode root) {
		super(root);
	}
	
	@Override
	public void accept(Visitor visitor) {
		synchronized(this) {
			super.accept(visitor);
		}
	}

}
